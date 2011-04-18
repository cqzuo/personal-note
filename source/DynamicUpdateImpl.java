/**
		* 文件名：DynamicUpdateImpl.java
		*
		* 版本信息：
		* 日期：2011-4-13
		* Copyright HengTong Corporation 2011
		* 版权所有
		*
		*/
package com.decg.base.common;

Import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.decg.base.DaoSupport;

/**
 *
 * 项目名称：decgNew
 * 类名称：DynamicUpdateImpl
 * 类描述：
 * 创建人：刘海林
 * 创建时间：2011-4-13 下午02:43:57
 * 修改人：刘海林
 * 修改时间：2011-4-13 下午02:43:57
 * 修改备注：
 * @version
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class DynamicUpdateImpl extends DaoSupport implements DynamicUpdate {

    //加入事务管理
	@Transactional
	//将新对象与数据库中对应的对象对比,更新变动的那些属性
	public void update(Object hisObj, Object newObj) {
	    //首先拿到新对象与老对象的Class类
		Class<?> hisObjClazz = hisObj.getClass();
		Class<?> newObjClazz = newObj.getClass();
		try {
		    // 新建List对象来存放 要更新的属性值,属性名称
			List<Object> updatedValues = new ArrayList<Object>();
			List<Object> updatedFieldNames = new ArrayList<Object>();
			List<Object> idFieldName = new ArrayList<Object>();
			List<Object> idFieldValue = new ArrayList<Object>();
			
			int k = 0;
			// 拿到老对象的所有声明的值域,放到Field对象数组中
			Field[] hisObjFields = hisObjClazz.getDeclaredFields();
			//遍历老对象的所有属性
			for (int i = 0; i < hisObjFields.length; i++) {
			    //分别拿到某个属性的值和名称,值存放在Field对象中,属性名放在String对象中
				Field hisObjField = hisObjFields[i];
				String hisObjFieldName = hisObjField.getName();
				//读取属性的id注释
				Id id = hisObjField.getAnnotation(Id.class);
				//取出老对象的属性在新对象中的对应的属性值
				Field newObjField = newObjClazz.getDeclaredField(hisObjFieldName);
				//如果该属性的id注释为空,执行
				if(id != null) {
				//读取老对象中该属性的是否可读性
					boolean flag = hisObjField.isAccessible();
				//设置该属性的可读属性
					hisObjField.setAccessible(true);
					Object hisObjValue = hisObjField.get(hisObj);
					hisObjField.setAccessible(flag);
					
					idFieldName.add(hisObjFieldName);
					idFieldValue.add(hisObjValue);
				} else {
					
					boolean flag = hisObjField.isAccessible();
					hisObjField.setAccessible(true);
					Object hisObjValue = hisObjField.get(hisObj);
					hisObjField.setAccessible(flag);
					
					flag = newObjField.isAccessible();
					newObjField.setAccessible(true);
					Object newObjValue = newObjField.get(newObj);
					newObjField.setAccessible(flag);
					
					if(!hisObjValue.equals(newObjValue)) {
						updatedValues.add(newObjValue);
						updatedFieldNames.add(hisObjFieldName);
					}
				}
				
			}
			
			String jpql = "";
			StringBuilder sb = new StringBuilder(100);
			sb.append(" update ").append(getEntityName(hisObjClazz)).append(" o set ");
			for (int i = 0; i < updatedFieldNames.size(); i++) {
				sb.append(" o.").append(updatedFieldNames.get(i)).append(" = ?").append(i+1).append(",");
				k++;
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append(" where ");
			
			if(idFieldName.size() == 0) {
				throw new RuntimeException("The entity" + getEntityName(hisObjClazz) + "dose not have ID field!");
			}
			
			
			for (int i = 0; i < idFieldName.size(); i++) {
				sb.append(" o.").append(idFieldName.get(i)).append("=?").append(k+1+i).append(" and ");
			}
			jpql = sb.substring(0, sb.length()-4);
			
			Query query = em.createQuery(jpql);
			setWhereParam(query, updatedValues);
			for (int i = 0; i < idFieldValue.size(); i++) {
				query.setParameter(k+1+i, idFieldValue.get(i));
			}
			query.executeUpdate();
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}

	public void update(Object entity) {
		try {
			Class<?> clazz = entity.getClass();
			List<Object> idFieldName = new ArrayList<Object>();
			List<Object> idFieldValue = new ArrayList<Object>();
			List<Object> updatedValues = new ArrayList<Object>();
			List<Object> updatedFieldNames = new ArrayList<Object>();
			int k = 0;
			
			Field[] fields = clazz.getDeclaredFields();
			
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String fieldName = field.getName();
				Id id = field.getAnnotation(Id.class);
				if(id != null) {
					idFieldName.add(fieldName);
					
					boolean flag = field.isAccessible();
					field.setAccessible(true);
					idFieldValue.add(field.get(entity));
					field.setAccessible(flag);
					
				} else {
					boolean flag = field.isAccessible();
					field.setAccessible(true);
					Object value = field.get(entity);
					field.setAccessible(flag);
					if(value != null) {
						updatedFieldNames.add(fieldName);
						updatedValues.add(value);
					}
				}
			}
			
			String jpql = "";
			StringBuilder sb = new StringBuilder(100);
			sb.append(" update ").append(getEntityName(clazz)).append(" o set ");
			for (int i = 0; i < updatedFieldNames.size(); i++) {
				sb.append(" o.").append(updatedFieldNames.get(i)).append(" = ?").append(i+1).append(",");
				k++;
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append(" where ");
			if(idFieldName.size() == 0) {
				throw new RuntimeException("The entity" + getEntityName(clazz) + "dose not have ID field!");
			}
			
			
			for (int i = 0; i < idFieldName.size(); i++) {
				sb.append(" o.").append(idFieldName.get(i)).append("=?").append(k+1+i).append(" and ");
			}
			jpql = sb.substring(0, sb.length()-4);
			Query query = em.createQuery(jpql);
			setWhereParam(query, updatedValues);
			for (int i = 0; i < idFieldValue.size(); i++) {
				query.setParameter(k+1+i, idFieldValue.get(i));
			}
			query.executeUpdate();
		
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}

	
	
}

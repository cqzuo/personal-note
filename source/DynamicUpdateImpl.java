/**
		* �ļ�����DynamicUpdateImpl.java
		*
		* �汾��Ϣ��
		* ���ڣ�2011-4-13
		* Copyright HengTong Corporation 2011
		* ��Ȩ����
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
 * ��Ŀ���ƣ�decgNew
 * �����ƣ�DynamicUpdateImpl
 * ��������
 * �����ˣ�������
 * ����ʱ�䣺2011-4-13 ����02:43:57
 * �޸��ˣ�������
 * �޸�ʱ�䣺2011-4-13 ����02:43:57
 * �޸ı�ע��
 * @version
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class DynamicUpdateImpl extends DaoSupport implements DynamicUpdate {

    //�����������
	@Transactional
	//���¶��������ݿ��ж�Ӧ�Ķ���Ա�,���±䶯����Щ����
	public void update(Object hisObj, Object newObj) {
	    //�����õ��¶������϶����Class��
		Class<?> hisObjClazz = hisObj.getClass();
		Class<?> newObjClazz = newObj.getClass();
		try {
		    // �½�List��������� Ҫ���µ�����ֵ,��������
			List<Object> updatedValues = new ArrayList<Object>();
			List<Object> updatedFieldNames = new ArrayList<Object>();
			List<Object> idFieldName = new ArrayList<Object>();
			List<Object> idFieldValue = new ArrayList<Object>();
			//�����϶������������,����������Ե�����ֵ��ͬ,�����Ե�ֵ�����Ʒ���List<Object>������
			int k = 0;
			// �õ��϶��������������ֵ��,�ŵ�Field����������
			Field[] hisObjFields = hisObjClazz.getDeclaredFields();
			//�����϶������������
			for (int i = 0; i < hisObjFields.length; i++) {
			    //�ֱ��õ�ĳ�����Ե�ֵ������,ֵ�����Field������,����������String������
				Field hisObjField = hisObjFields[i];
				String hisObjFieldName = hisObjField.getName();
				//��ȡ���Ե�idע��
				Id id = hisObjField.getAnnotation(Id.class);
				//ȡ���϶�����������¶����еĶ�Ӧ�����Զ���
				Field newObjField = newObjClazz.getDeclaredField(hisObjFieldName);
				//��������Բ���id����,ִ�����²���
				if(id != null) {
				//��ȡ�϶����и����Ե��Ƿ�ɶ���
					boolean flag = hisObjField.isAccessible();
				//���÷��ʸ�����ʱ��������Ȩ��,��private��protectҲ���Է���
					hisObjField.setAccessible(true);
					//ȡ�ø��϶����и����Ե�ֵ,����Object������
					Object hisObjValue = hisObjField.get(hisObj);
					//�����϶������Եķ���Ȩ��,ֵ����Ϊԭ��Ȩ��
					hisObjField.setAccessible(flag);
					//�����Ե����Ʒ���List<Object>��
					idFieldName.add(hisObjFieldName);
					//�����Ե�ֵ����List<Object>��
					idFieldValue.add(hisObjValue);
				} else {//�����������id����,��ִ�����²���
					//ȡ�ø����Եķ���Ȩ������
					boolean flag = hisObjField.isAccessible();
					//ȡ�������Եķ���Ȩ��
					hisObjField.setAccessible(true);
					//ȡ�ø��϶����и����Ե�ֵ,����Object������
					Object hisObjValue = hisObjField.get(hisObj);
					//�����϶������Եķ���Ȩ��,ֵ����Ϊԭ��Ȩ��
					hisObjField.setAccessible(flag);
					//ȡ���¶������Եķ���Ȩ��
					flag = newObjField.isAccessible();
					//ȡ�������Եķ���Ȩ��
					newObjField.setAccessible(true);
					//ȡ�ø��¶����и����Ե�ֵ,����Object������
					Object newObjValue = newObjField.get(newObj);
					//�����¶������Եķ���Ȩ��,ֵ����Ϊԭ��Ȩ��
					newObjField.setAccessible(flag);
					//����϶�����������Ժ��¶�����������Բ���,��ִ�����²���
					if(!hisObjValue.equals(newObjValue)) {
						//���¶��������ֵ����List<Object>����updatedValues��
						updatedValues.add(newObjValue);
						//���¶�����������Ʒ���List<Object>����updatedFieldNames��
						updatedFieldNames.add(hisObjFieldName);
					}
				}
				
			}
			//��������ıȶԽ��ƴsql���
			//����һ����String����jpql
			String jpql = "";
			//����һ��StringBuilder����sb
			StringBuilder sb = new StringBuilder(100);
			//���ø��µĶ���  �൱�� update ʵ������ o set 
			sb.append(" update ").append(getEntityName(hisObjClazz)).append(" o set ");
			// ����
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

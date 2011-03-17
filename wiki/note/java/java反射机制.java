JAVA�������
    JAVA���������������״̬�У���������һ���࣬���ܹ�֪���������������Ժͷ�������������һ�����󣬶��ܹ�������������һ�����������ֶ�̬��ȡ����Ϣ�Լ���̬���ö���ķ����Ĺ��ܳ�Ϊjava���Եķ�����ơ�
Java���������Ҫ�ṩ�����¹��ܣ� ������ʱ�ж�����һ�������������ࣻ������ʱ��������һ����Ķ���������ʱ�ж�����һ���������еĳ�Ա�����ͷ�����������ʱ��������һ������ķ��������ɶ�̬����
1. �õ�ĳ�����������

1 public Object getProperty(Object owner, String fieldName) throws Exception {
2     Class ownerClass = owner.getClass();
3
4     Field field = ownerClass.getField(fieldName);
5
6     Object property = field.get(owner);
7
8     return property;
9 }
Class ownerClass = owner.getClass()���õ��ö����Class��

Field field = ownerClass.getField(fieldName)��ͨ��Class�õ������������ԡ�

Object property = field.get(owner)��ͨ������õ������Ե�ʵ���������������Ƿǹ��еģ�����ᱨIllegalAccessException��

2. �õ�ĳ����ľ�̬����

 1 public Object getStaticProperty(String className, String fieldName)
 2             throws Exception {
 3     Class ownerClass = Class.forName(className);
 4
 5     Field field = ownerClass.getField(fieldName);
 6
 7     Object property = field.get(ownerClass);
 8
 9     return property;
10 }

Class ownerClass = Class.forName(className) �����ȵõ�������Class��

Field field = ownerClass.getField(fieldName)��������һ����ͨ��Class�õ������������ԡ�

Object property = field.get(ownerClass) �������������Щ��ͬ����Ϊ�������Ǿ�̬�ģ�����ֱ�Ӵ����Class��ȡ��

3. ִ��ĳ����ķ���

 1 public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
 2
 3     Class ownerClass = owner.getClass();
 4
 5     Class[] argsClass = new Class[args.length];
 6
 7     for (int i = 0, j = args.length; i < j; i++) {
 8         argsClass[i] = args[i].getClass();
 9     }
10
11     Method method = ownerClass.getMethod(methodName, argsClass);
12
13     return method.invoke(owner, args);
14 }
Class owner_class = owner.getClass() �����Ȼ��Ǳ���õ���������Class��

5��9�У����ò�����Class���飬��ΪѰ��Method��������

Method method = ownerClass.getMethod(methodName, argsClass)��ͨ��Method���Ͳ�����Class����õ�Ҫִ�е�Method��

method.invoke(owner, args)��ִ�и�Method��invoke�����Ĳ�����ִ����������Ķ��󣬺Ͳ������顣����ֵ��Object��Ҳ���Ǹ÷����ķ���ֵ��

4. ִ��ĳ����ľ�̬����

 1 public Object invokeStaticMethod(String className, String methodName,
 2             Object[] args) throws Exception {
 3     Class ownerClass = Class.forName(className);
 4
 5     Class[] argsClass = new Class[args.length];
 6
 7     for (int i = 0, j = args.length; i < j; i++) {
 8         argsClass[i] = args[i].getClass();
 9     }
10
11     Method method = ownerClass.getMethod(methodName, argsClass);
12
13     return method.invoke(null, args);
14 }

������ԭ���ʵ��3��ͬ����ͬ�������һ�У�invoke��һ��������null����Ϊ���Ǿ�̬����������Ҫ����ʵ�����С�

5. �½�ʵ��
 1
 2 public Object newInstance(String className, Object[] args) throws Exception {
 3     Class newoneClass = Class.forName(className);
 4
 5     Class[] argsClass = new Class[args.length];
 6
 7     for (int i = 0, j = args.length; i < j; i++) {
 8         argsClass[i] = args[i].getClass();
 9     }
10
11     Constructor cons = newoneClass.getConstructor(argsClass);
12
13     return cons.newInstance(args);
14
15 }

����˵�ķ�����ִ�д������Ĺ��캯�����½�ʵ���ķ������������Ҫ����������ֱ��ʹ��newoneClass.newInstance()��ʵ�֡�

Class newoneClass = Class.forName(className)����һ�����õ�Ҫ�����ʵ����Class��

��5����9�У��õ�������Class���顣

Constructor cons = newoneClass.getConstructor(argsClass)���õ������ӡ�

cons.newInstance(args)���½�ʵ����

6. �ж��Ƿ�Ϊĳ�����ʵ��

1 public boolean isInstance(Object obj, Class cls) {
2     return cls.isInstance(obj);
3 }

7. �õ������е�ĳ��Ԫ��
1 public Object getByArray(Object array, int index) {
2     return Array.get(array,index);
3 }


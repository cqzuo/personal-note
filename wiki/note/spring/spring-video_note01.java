1.spring访问底层资源的两种途径？
2.AOP的一些基本概念:切面 关注点 连接点 切入点 通知 引入 目标对象 AOP代理 织入 前端通知 返回后通知 抛出异常后通知 好哦通知 环绕通知？
3.一个实现AOP的例子(目标对象 通知对象 监听器注册 )
4.ASPECT J配置
5.如何截取参数并自定义返回值
资源
 Resource接口 (提供了更强的访问底层资源能力的抽象)
 两种方式: 获得一个Resource接口,通过Resource接口获取资源
          将资源配置为属性,来让容器注入
 <bean id="test" class="spring.Test">
    <property name="templete">
        <value>D:/sources/test.txt</value>
    </property>
 </bean>
 
 AOP切面编程
  AOP是一种编程范式(面向切面编程)
  优势:可装配化 组件化
  spring中使用的AOP:
     提供声明式企业服务(替代EJB)
     允许用户实现自定义切面
  AOP概念
     切面 关注点的模块化
     关注点 关注的功能点
     连接点 程序执行过程中某个特定的点(包含关注点的方法)
     通知 在切面的某个特定的连接点上执行的动作（关注点功能的实现）
     切入点 匹配连接点的断言(连接点的集合)
     引入 声明额外的方法或者某个类型的字段
     目标对象 被一个或多个切面通知的对象(包含关注点的对象)
     AOP代理 AOP框架所创建的对象,用来实现切面契约
     织入 将切面连接到其他应用程序或对象上，并创建一个被通知的对象
  通知的类型(跟事件机制的触发时间同)
     前端通知 在某连接点之前的通知
     返回后通知 在某连接点正常执行完成之后的通知(抛出异常后不执行)
     抛出异常后通知 在方法抛出异常后退出执行的通知
     后通知   在某连接点退出时执行的通知(不管是否抛出异常)
     环绕通知 包围连接点的通知(在调用方法前后完成自定义的行为)
AOP组成
  proxy 代理(把连接点后advice连接起来)
  weaving 织入(把功能加回)
AOP的流程
spring aop的功能和目标
 spring是java实现的
 目前只支持方法作为连接点
 spring支持CGLIB动态代理包和j2se动态代理
一个aop实现的例子
	 target类 (不需要的原来的了做任何改变)
	 advice类
public class MyAroundAdvice
	 {
	     private Object cc(ProceedingJoinPoint pj) throws Throwable
	     {
		 System.out.println("before advice");
		 Object obj = pj.proceed();
		 System.out.println("after advice");
		 return obj;
	     }
	 }
	 监听器注册
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="
          http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd 
          http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">
  <aop:config>//aop配置内容
    <aop:aspect ref="advice">//配置aop切面 ref名称可以随便写，但定义的通知类必须在bean中注册，且与id值相同
      <aop:point-cut method="myPointCut" expression="execution(* spring.BEbo.test())"/>//配置切入点名称及方法名，事件的响应方法
      <aop:around pointcut-ref="myPointCut" method="cc"/>//设置通知名称及方法
    </aio:aspect>
  </aop:config> 
<bean id="advice" class="spring.aop.MyAroundAdvice"/>
http://www.eclipse.org/downloads/download.php?file=/webtools/downloads/drops/R1.5/R-1.5.3-200702082048/wtp-wst-R-1.5.3.zip

Aspect J 配置
  启动AspectJ <aop:aspectj autoproxy />
 java5以后 注释的扩展 注解(格式语法检查等)
＠override 定义检查
AOP的注解配置方法
目标对象不变
xml配置文件中加入
       <aop:aspectj-autoproxy />
在通知中加入
       import org.aspectj.lang.anotation.Aspect;
@Aspect//表明此处为通知
public class MyAroundAdvice
	 {
	   @Around("execution(* spring.BEbo.test())")//匹配方法执行的连接点
	     private Object cc(ProceedingJoinPoint pj) throws Throwable
	     {
		 System.out.println("before advice");
		 Object obj = pj.proceed();
		 System.out.println("after advice");
		 return obj;
	     }
}
此处@Around("execution(* **.*.*())") //表明监听的为任意位置下的无参方法

@Around("execution(* **.*.*(..))")//表明监听的为任意位置下的任意方法
@Around("execution(* **.*.*a(..))")//表明监听的为任意位置下的以a结尾的方法
@Around("execution(* **.*.*a(*))")//表明监听的为任意位置下的以a结尾的含有一个参数的方法
@Around("execution(* **.*.*(* String))")//表明监听的为任意位置下的含有两个参数，后一个为String的方法
  类的构造和注入不去监控,
  接口中如果抛出异常,则实现接口时也必须抛出小于等于接口异常的 异常
此处@Around("execution(public * **.*.*())") //表明监听的为任意位置下的无参public方法
此处@Around("execution(* test..*.*())") //表明监听的为test子包下的无参方法

拦截方法中的参数.自定义返回值
  @Around("execution(* **.*.*a(..))&& args(str)")
  import org.aspectj.lang.anotation.Aspect;
@Aspect//表明此处为通知
class  MyAroundAdvice
{
  @Around("execution(* **.*.*a(..))&& args(str)")//参数名称必须与通知方法参数名相同
  private Object cc(ProceedingJoinPoint pj,String str) throws Throwable
    {
      System.out.println("before advice");
      Object obj = pj.proceed();
      System.out.println("after advice");
      System.out.println(pj.getTarget()+"."+pj.getSignature().getName());
      System.out.println("截获的参数为"+str);
      return obj;
    }
}
//此时就可以截获到所有参数为String的方法
@Around("execution(* **.*.*a(..))&& args(str,arg1,arg2)")//如果截取多个参数,execution的参数必须和args的参数匹配
before 通知
@Before("execution(* **.*.*(..))&& args(str)") 设置前端通知并截取参数(没有返回值)
声明一个切入点
import org.aspectj.lang.anotation.Aspect;
@Aspect//表明此处为通知
public class MyAroundAdvice
 {
   @Pointcut("execution(* **..*.*(..))")//在此处用一个空方法来声明切入点,
   public void t(String str){}//空方法参数必须和要截取的参数同类型,否则报错
   @Around("t()&& args(str)")//参数名称必须与通知方法参数名相同
   
   private Object cc(ProceedingJoinPoint pj,String str) throws Throwable
   {
     System.out.println("before advice");
     Object obj = pj.proceed();
     System.out.println("after advice");
     System.out.println(pj.getTarget()+"."+pj.getSignature().getName());
     System.out.println("截获的参数为"+str);
     return obj;
   }
}
声明pointcut时,execution()方法必须放在上面，截取参数的方法必须放在下面
  @pointcut标签的使用
  如果含有多个通知,且监听的方法相同，则可以使用@pointcut注解了实现代码重用
如果需要满足两个方法，则可以设置两个@Pointcut注解
  @Pointcut("execution(* **..*.*(..))")
  public void t(String str){}
@Around(t()&&args(str))
private Object cc(ProceedingJoinPoint pj,String str) throws Throwable
{
  System.out.println("before advice");
  Object obj = pj.proceed();
  System.out.println("after advice");
  System.out.println(pj.getTarget()+"."+pj.getSignature().getName());
  System.out.println("截获的参数为"+str);
  return obj;
}
@Before(t()&&args(str))
private Object cc1(String str) throws Throwable
{
  System.out.println("before advice");
  System.out.println("截获的参数为"+str);
}
如何截取参数
import org.aspectj.lang.anotation.Aspect;
@Aspect//表明此处为通知
public class MyAroundAdvice
 {
   @Pointcut("execution(* **..*.*(..))")//在此处用一个空方法来声明切入点,
   public void t(String str){}//空方法参数必须和要截取的参数同类型,否则报错
   @AfterReturning()
   private Object cc(ProceedingJoinPoint pj,String str) throws Throwable
   {
     System.out.println("before advice");
     Object obj = pj.proceed();
     System.out.println("after advice");
     System.out.println(pj.getTarget()+"."+pj.getSignature().getName());
     System.out.println("截获的参数为"+str);
     return obj;
   }
}
合并切入点表达式
&& || !
注意下面通知方法的参数和声明pointcut中execution中参数和监听对象的切入点方法的参数必须一致

声明通知
 @Around @Before @AfterReturning @After
调用通知的顺序 @Before--->@AroundBefore
after通知的顺序 @AroundAfter最后 @After @AfterReturning顺序由各自在代码中的先后位置决定
在设计aop时，避免执行顺序无关
如何截取返回值
 import org.aspectj.lang.anotation.Aspect;
@Aspect//表明此处为通知
public class MyAroundAdvice
 {
   @Pointcut("execution(* **..*.*(..))")//在此处用一个空方法来声明切入点,
   public void t(String str){}//空方法参数必须和要截取的参数同类型,否则报错
   @AfterReturning(pointcut="cc()",returning="abc")
   private cc(Object abc) throws Throwable
   {
     System.out.println("the afterReturning--"+abc);//此处打印监听方法返回的值
   }
}
AOP的schema的配置方法
<aop:config>
     <aop:aspect id="MyAspect" ref="myBean">
  ........
     </aop:aspect> 
</aop:config>
  <bean id="myBean" class="spring.MyBean">
  </bean>
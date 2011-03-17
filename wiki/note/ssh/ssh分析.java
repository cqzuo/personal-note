HibernateDaoSupport的使用
2008-03-06 16:34
一.“低耦合、高内聚”:
低耦合:就是软件在构造的时候，各个模块、各个功能、各个类都不会过度依赖于它周围的环境。只有这样，才能使我们的模块（功能、类）在周围发生变更时不受影响，做到易于维护和易于适应变更。正因为如此，也使它更易于重用到其它功能类似的环境中，提高了重用性。
高内聚:则使软件中的各个模块（功能、类）能够各尽其能而又充分合作，也就是对于软件问题空间中需求的各个功能，系统可以合理地把它分配给各个模块（功能、类）来共同完成，而不是一个或几个八面玲珑、包打天下的超级类一个人完成。而对于该系统中的某一个模块（功能、类），具有自己高度相关的职责，即该职责中的几个任务是高度相关的。每一个模块（功能、类）都决不去完成与自己无关职责的任务。
二.struts+spring+hibernate给这种设计提供了方便
1.使用struts我们可以应用MVC模型，使页面展现与业务逻辑分离，做到了页面展现与业务逻辑的低耦合。当我们的页面展现需要变更时，我们只需要修改我们的页面，而不影响我们的业务逻辑；

2.使用spring我们运用IoC（反向控制），降低了业务逻辑中各个类的相互依赖。假如类A因为需要功能F而调用类B，在通常的情况下类A需要引用类B，因而类A就依赖于类B了，也就是说当类B不存在的时候类A就无法使用了。使用了IoC，类A调用的仅仅是实现了功能F的接口的某个类，这个类可能是类B，也可能是另一个类C，由spring的配置文件来决定。这样，类A就不再依赖于类B了，耦合度降低，重用性提高了。

3.使用hibernate则是使我们的业务逻辑与数据持久化分离，也就是与将数据存储到数据库的操作分离。我们在业务逻辑中只需要将数据放到值对象中，然后交给hibernate，或者从hibernate那里得到值对象。至于用Oracle、MySQL还是SQL Server，如何执行的操作，与我无关。


三.设计时候需要改进的地方

1.编写DAO的时候尽量不直接使用hibernate或者spring对hiberanate的支持

现在我们在编写DAO的时候普遍都是直接继承spring对hibernate的封装类HibernateDaoSupport，然后使用该类提供的诸如saveOrUpdate(), saveOrUpdateCopy(), find()等等。另外，在使用excute()方法实现一些更复杂的hibernate功能的时候还会使用hibernate的类，诸如Query, Session, Type等。这样直接使用spring和hibernate的类存在的问题在于，你的代码将不得不依赖与spring和hibernate的某个版本。比如说，现在hibernate3出来了，改动挺大，实际上最要命的是包结构，hibernate2的包结构是net.sf.hibernate.*，然而hibernate3是org.hibernate.*。同样，spring为了支持hibernate3，包名也改为org.springframework.orm.hibernate3.*。假如，你现在新开发一个项目，这没什么关系，如果是升级一个项目问题就来了。如果你希望将你的一个项目从hibernate2升级为hibernate3，你不得不修改DAO中所有对hibernate和spring-hibernate的引用。如果你的代码中出现hibernate2与hibernate3不兼容的方法和类，比如saveOrUpdateCopy()（在hibernate3中已经没有了）,你还将不得不改写。那么你可能会说，我不会这样升级。如果你的软件生命周期有好多年，hibernate升级到4，升级到5，你还是依然使用hibernate2？如果你以这种方式开发一个平台，你能要求所有使用你平台的软件项目都只能使用hibernate2？更进一步说，我现在开发一个产品，今后的客户将是成千上万。经过1、2年我需要升级了，这时我的升级包有几十M，几乎把所有的DAO都换了个遍，这样的升级无异于重装。


分析原因:是我们项目中的DAO依赖于hibernate和spring，因为我们对它们的使用是继承，是一种很强的关联，就是一种依赖.


解决方案一:我们只需要稍微进行一些调整，就可以解决这个问题，那就是不使用直接继承，而使用接口进行分离。可以使用Fa鏰de模式，先建立一个叫BasicDao的基础类，从名称我们可以看出，它是所有DAO的基础类，实现DAO操作所需的所有诸如save()、delete()、load()、query()等方法，除了一些基本的方法，诸如翻页查询、getCount、解析查询条件形成HQL语句等功能也在这里实现，但是不要使用与hibernate或spring有关的任何方法和类。同时，BasicDao调用一个叫DaoSupport的接口，DaoSupport的接口则是提供持久化所需的基本方法，最原始的元素。然后，我为DaoSupport接口提供各种不同的实现，比如hibernate2的实现DaoSupportHibernateImp、hibernate3的实现DaoSupportHibernate3Imp，整个结构如下图所示。BasicDao可以使用hibernate或spring提供的方法，但是不是直接使用，而是通过调用DaoSupport的实现类来使用。然而BasicDao到底是使用的那个实现类，我们通过spring的IoC，通过配置文件来决定到底使用哪个实现。同时，BasicDao也不要使用诸如SpringContext的类来实现IoC，而是通过建立setDaoSupport()和getDaoSupport()方法，然后在spring配置文件中建立引用。


四．实际开发中的应用

１．dao

public interface Dao:主要封装实现具体数据访问的接口

２．impl

public class BaseDaoImpl extends HibernateDaoSupport implements Dao

具体的实现

３．其他dao

public class ArticleDaoImpl implements ArticleDao{


   private Dao dao;

   private byte status = 0;

   public Dao getDao() {
    return this.dao;
   }

   public void setDao(final Dao dao) {
    this.dao = dao;
   }

}

有这样的引用．这样在代码其他DAO里面就可以利用DAO接口来做些操作了.
 

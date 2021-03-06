掌握如何创建类和构造对象掌握方法的重载和覆盖了解类的继承了解包概念

1.一个类继承另外一个类的方式是使用extends语句，如A extends B，表示A类继承B类，B类称为父类或者基类，A类称为子类或者派生类。
  子类默认自动获得父类的全部成员，包括属性和方法
2.子类的变异
	子类添加新的成员
	子类修改父类成员
3.如果子类和父类具有一个同名方法，外界在调用子类对象的这个方法时，总是使用子类的方法。此时，父类的同名方法被子类隐藏起来了。这种机制称之为“重写”（   Override）重写的方式会导致父类的同名方法不会在子类同名方法被调用时被执行，所以，一般需要在子类方法中将父类同名方法中的必要功能代码重新书写一次。如上述程序中，可以看出Circle的toString()方法和Point类的toString()方法存在相同的代码部分，都需要构造点的表达方式，如"("和")"等。利用系统提供的super引用可以在子类中访问到被隐藏起来的父类同名方法，利用这种方式可以有效的复用被隐藏起来的父类同名方法
4.protected类型    
	添加访问修饰符protected修饰父类的成员，可以只允许子类直接访问父类中的该成员，而其他的一般类都不行，这样使得父类可以将直接访问权限只赋予子类
      Java语言中有个额外的规定，那就是protected类型的成员也可以看成是friendly类型，因此，同一个包里的其他类也可以直接访问该类的protected类型成员
5.继承中的构造函数
	子类在调用构造函数进行对象创建的时候，将首先调用父类的构造函数，原因在于父类的构造函数中可能存在初始化父类成员的代码，如果此时直接执行子类的构造函数，就会导致子类可能因为使用到那些没有被正确初始化的父类成员而产生错误。
6.Object类
      它提供了一些所有类都需要的基本方法成员，它也是所有类的基类，任何类都是派生于此类，即如果一个类不显式的表明基类，则默认就是派生于此类
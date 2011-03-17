import   java.util.linkedlist;     
      
  public   abstract   class   manager   {     
      
          private   string   mthreadpoolname   =   null;     
      
          private   int   mthreadpoolmaxsize   =   1;     
      
          private   linkedlist   workers   =   new   linkedlist();     
      
          public   manager()   {     
          }     
      
          public   manager(string   name,   int   poolmaxsize)   {     
                  mthreadpoolname   =   name;     
                  createworker(name,   poolmaxsize);     
                  mthreadpoolmaxsize   =   poolmaxsize;     
          }     
      
          private   void   createworker(int   poolmaxsize)   {     
                          for   (int   i   =   0;   i   <   poolmaxsize;   i++)   {     
                                  worker   worker   =   new   ...worker(this);     
                                  workers.addlast(worker);     
                          }     
          }     
      
          public   synchronized   worker   getidleworker()   {     
                  return   (worker)workers.removefirst();     
          }     
      
          public   synchronized   void   notifyfree(worker   worker)   {     
                  if   (workers.size()   <   mthreadpoolmaxsize)   {     
                          workers.addlast(worker);     
                  }   else   {     
                          worker   =   null;     
                  }     
          }     
      
          public   int   getthreadpoolmaxsize()   {     
                  return   mthreadpoolmaxsize;     
          }     
      
          public   void   setthreadpoolmaxsize(int   threadpoolmaxsize)   {     
                  this.mthreadpoolmaxsize   =   threadpoolmaxsize;     
          }     
      
  }     

     
  线程抽象类   
    
  
Java代码 
public   abstract   class   worker   implements   runnable   {     
      
          private   manager   mmanager   =   null;     
      
          private   thread   mthread   =   null;     
          
          public   worker()   {     
          }     
      
          public   worker(string   threadname,   manager   manager)   {     
                  mmanager   =   manager;     
                  mthread   =   new   thread(this,   threadname);     
                  init();     
                  mthread.start();     
          }     
      
          public   abstract   void   init();     
      
          public   void   run()   {     
                  while   (true)   {     
                          waitforstart();     
                          worker   worker   =   mmanager.getidleworker();     
                          process();     
                          isrunning   =   false;     
                          mmanager.notifyfree(worker);     
                  }     
          }     
      
          public   abstract   void   process();     
      
          public   void   start()   {     
                  isrunning   =   true;     
                  mmanager.getidleworker();     
                  notifytostart();     
          }     
      
          public   synchronized   void   waitforstart()   {     
                  try   {     
                          wait();     
                  }   catch   (interruptedexception   ex)   {     
                  }     
          }     
      
          public   synchronized   void   notifytostart()   {     
                  notify();     
          }     
      
  }     
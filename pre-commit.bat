@echo off  
 setlocal  

 set REPOS=%1  
 set TXN=%2           

rem ��֤����8���ַ�
 svnlook log %REPOS% -t %TXN% | findstr "........" > nul
 if %errorlevel% gtr 0 goto :err_action

rem ���˿ո��ַ�
svnlook log %REPOS% -t %TXN% | findstr /ic:"        " > nul
 if %errorlevel% gtr 0 goto :success
 
 :err_action
 echo �㱾�ΰ汾�ύδ��д�κα������־˵����Ϣ.      >&2
 echo �벹����־˵����Ϣ�����ύ����,����:����˵����.  >&2
 echo �������־��Ϣ������8���ַ�˵��(��4������),лл! >&2
 echo *******************��ֹ�ո�����***************** >&2
 goto :err_exit
  :err_exit
 exit 1
 
 :success
 exit 0
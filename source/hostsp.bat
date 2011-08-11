REM 中文
@echo off
ipconfig /flushdns
attrib %windir%\System32\drivers\etc\hosts -s -h -r
cls
goto begin

:begin
echo ---------------------------------------------------------------------------
echo 全系列Google服务hosts修改器 110811-2122

ver | find "5." >nul
if errorlevel 1 echo.& echo 请确认您已经以管理员身份运行。
echo.
echo 1.安装/更新
echo.
echo 2.卸载
echo 3.工具
echo 4.退出
echo ---------------------------------------------------------------------------
echo.
SET /P ST= 请输入相应序号（1，2，3，4）：
echo.
if /I "%ST%"=="1" goto install
if /I "%ST%"=="2" goto remove
if /I "%ST%"=="3" goto tools
if /I "%ST%"=="4" goto exit
exit

:tools
cls
echo ---------------------------------------------------------------------------
echo HOSTSpv4 Tools 110811-2122
echo.
echo 1.卸载
echo 2.查看IP
echo 3.从IP添加..
echo 4.从域名添加..
echo 5.自行编辑hosts
echo 6.使用www.g.cn的IP
echo 7.查看当前ip
echo.
echo 8.返回上级
echo 9.退出
echo ---------------------------------------------------------------------------
echo.
SET /P TT= 请输入相应序号（1-9）：
echo.
if /I "%TT%"=="1" goto remove
if /I "%TT%"=="2" goto echoip
if /I "%TT%"=="3" goto manualip
if /I "%TT%"=="4" goto manual
if /I "%TT%"=="5" goto edithosts
if /I "%TT%"=="6" goto showip
if /I "%TT%"=="7" goto gcn
if /I "%TT%"=="8" goto begin
if /I "%TT%"=="9" goto exit
exit

:install

if exist "%windir%\System32\drivers\etc\hosts_hpbak" (echo 备份文件已存在。) else copy %windir%\System32\drivers\etc\hosts %windir%\System32\drivers\etc\hosts_hpbak
cls

echo 全系列Google服务hosts修改器
echo 请稍等一下,正在通过网络获取可用IP
echo.


for /f "tokens=2 delims=[]" %%i in ('ping gpcom.azlyfox.com') do set IP=%%i
goto doit

:gcn

if exist "%windir%\System32\drivers\etc\hosts_hpbak" (echo 备份文件已存在。) else copy %windir%\System32\drivers\etc\hosts %windir%\System32\drivers\etc\hosts_hpbak
cls

echo 全系列Google服务hosts修改器
echo 请稍等一下,正在通过网络获取可用IP
echo.


for /f "tokens=2 delims=[]" %%i in ('ping www.g.cn') do set IP=%%i
goto doit

:manual

if exist "%windir%\System32\drivers\etc\hosts_hpbak" (echo 备份文件已存在。) else copy %windir%\System32\drivers\etc\hosts %windir%\System32\drivers\etc\hosts_hpbak
cls

echo 全系列Google服务hosts修改器
echo.


SET /P pingname= 请输入一个域名：
for /f "tokens=2 delims=[]" %%i in ('ping %pingname%') do set IP=%%i

goto doit

:manualip

if exist "%windir%\System32\drivers\etc\hosts_hpbak" (echo 备份文件已存在。) else copy %windir%\System32\drivers\etc\hosts %windir%\System32\drivers\etc\hosts_hpbak
cls

echo 全系列Google服务hosts修改器
echo.


SET /P pingname= 请输入一个IP：
set IP=%pingname%

goto doit

:doit

echo %IP%

type %windir%\System32\drivers\etc\hosts|find "#THISISNOTE" /i /v|find "#Google Plus" /i /v|findstr "." >>%windir%\System32\drivers\etc\hosts_temp
ren %windir%\System32\drivers\etc\hosts hosts_temp_del
ren %windir%\System32\drivers\etc\hosts_temp hosts
del %windir%\System32\drivers\etc\hosts_temp_del /s /q


echo.  >>%windir%\System32\drivers\etc\hosts
echo #Google Plus >>%windir%\System32\drivers\etc\hosts


REM echo %IP% www.google.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% plus.google.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% talkgadget.google.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% picasaweb.google.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh1.ggpht.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh2.ggpht.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh3.ggpht.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh4.ggpht.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh5.ggpht.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh6.ggpht.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh6.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh5.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh4.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh3.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh2.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% lh1.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% images1-focus-opensocial.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% images2-focus-opensocial.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% images3-focus-opensocial.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% images4-focus-opensocial.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% images5-focus-opensocial.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% images6-focus-opensocial.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% s6.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% s5.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% s4.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% s3.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% s2.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% s1.googleusercontent.com  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% plus.google.com.hk  #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% webcache.googleusercontent.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts

echo %IP% youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% www.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% gdata.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% m.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP%  help.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% upload.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% accounts.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% insight.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% apiblog.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% clients1.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% s.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% s2.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% s.ytimg.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% i1.ytimg.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% i2.ytimg.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% i3.ytimg.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% i4.ytimg.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v1.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v2.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v3.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v4.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v5.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v6.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v7.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v8.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v9.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v10.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v11.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v12.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v13.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v14.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v15.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v16.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v17.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v18.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v19.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v20.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v21.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v22.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v23.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v24.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v1.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v2.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v3.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v4.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v5.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v6.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v7.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v8.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v9.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v10.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v11.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v12.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v13.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v14.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v15.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v16.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v17.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v18.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v19.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v20.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v21.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v22.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v23.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v24.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v1.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v2.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v3.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v4.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v5.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v6.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v7.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v8.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v9.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v10.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v11.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v12.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v13.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v14.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v15.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v16.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v17.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v18.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v19.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v20.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v21.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v22.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v23.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v24.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v1.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v2.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v3.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v4.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v5.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v6.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v7.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v8.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v9.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v10.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v11.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v12.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v13.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v14.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v15.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v16.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v17.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v18.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v19.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v20.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v21.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v22.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v23.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v24.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v1.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v2.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v3.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v4.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v5.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v6.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v7.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v8.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v9.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v10.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v11.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v12.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v13.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v14.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v15.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v16.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v17.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v18.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v19.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v20.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v21.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v22.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v23.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v24.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v1.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v2.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v3.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v4.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v5.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v6.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v7.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v8.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v9.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v10.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v11.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v12.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v13.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v14.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v15.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v16.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v17.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v18.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v19.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v20.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v21.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v22.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v23.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v24.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v1.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v2.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v3.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v4.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v5.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v6.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v7.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v8.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v9.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v10.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v11.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v12.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v13.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v14.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v15.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v16.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v17.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v18.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v19.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v20.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v21.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v22.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v23.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v24.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v1.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v2.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v3.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v4.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v5.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v6.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v7.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v8.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v9.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v10.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v11.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v12.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v13.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v14.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v15.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v16.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v17.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v18.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v19.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v20.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v21.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v22.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v23.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% o-o.preferred.sjc07s15.v24.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r1.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r2.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r3.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r4.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r5.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r6.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r7.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r8.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r9.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r10.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r11.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r12.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r13.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r14.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r15.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r16.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r17.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r18.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r19.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r20.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r21.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r22.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r23.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% r24.pek01s01.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v1.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v2.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v3.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v4.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v5.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v6.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v7.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v8.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v9.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v10.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v11.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v12.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v13.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v14.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v15.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v16.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v17.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v18.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v19.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v20.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v21.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v22.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v23.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v24.cache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v1.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v2.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v3.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v4.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v5.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v6.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v7.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v8.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v9.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v10.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v11.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v12.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v13.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v14.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v15.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v16.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v17.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v18.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v19.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v20.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v21.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v22.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v23.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v24.cache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v1.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v2.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v3.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v4.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v5.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v6.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v7.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v8.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v9.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v10.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v11.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v12.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v13.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v14.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v15.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v16.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v17.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v18.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v19.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v20.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v21.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v22.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v23.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v24.cache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v1.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v2.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v3.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v4.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v5.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v6.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v7.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v8.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v9.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v10.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v11.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v12.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v13.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v14.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v15.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v16.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v17.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v18.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v19.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v20.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v21.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v22.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v23.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v24.cache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v1.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v2.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v3.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v4.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v5.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v6.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v7.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v8.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v9.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v10.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v11.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v12.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v13.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v14.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v15.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v16.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v17.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v18.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v19.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v20.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v21.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v22.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v23.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v24.cache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v1.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v2.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v3.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v4.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v5.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v6.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v7.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v8.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v9.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v10.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v11.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v12.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v13.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v14.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v15.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v16.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v17.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v18.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v19.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v20.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v21.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v22.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v23.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v24.cache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v1.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v2.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v3.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v4.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v5.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v6.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v7.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v8.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v9.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v10.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v11.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v12.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v13.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v14.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v15.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v16.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v17.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v18.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v19.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v20.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v21.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v22.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v23.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v24.cache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v1.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v2.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v3.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v4.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v5.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v6.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v7.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v8.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v9.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v10.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v11.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v12.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v13.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v14.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v15.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v16.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v17.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v18.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v19.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v20.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v21.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v22.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v23.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% tc.v24.cache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v1.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v2.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v3.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v4.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v5.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v6.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v7.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v8.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v9.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v10.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v11.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v12.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v13.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v14.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v15.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v16.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v17.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v18.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v19.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v20.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v21.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v22.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v23.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v24.lscache1.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v1.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v2.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v3.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v4.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v5.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v6.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v7.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v8.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v9.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v10.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v11.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v12.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v13.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v14.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v15.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v16.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v17.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v18.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v19.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v20.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v21.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v22.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v23.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v24.lscache2.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v1.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v2.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v3.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v4.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v5.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v6.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v7.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v8.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v9.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v10.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v11.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v12.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v13.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v14.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v15.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v16.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v17.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v18.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v19.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v20.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v21.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v22.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v23.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v24.lscache3.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v1.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v2.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v3.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v4.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v5.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v6.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v7.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v8.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v9.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v10.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v11.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v12.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v13.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v14.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v15.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v16.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v17.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v18.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v19.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v20.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v21.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v22.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v23.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v24.lscache4.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v1.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v2.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v3.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v4.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v5.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v6.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v7.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v8.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v9.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v10.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v11.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v12.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v13.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v14.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v15.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v16.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v17.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v18.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v19.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v20.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v21.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v22.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v23.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v24.lscache5.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v1.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v2.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v3.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v4.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v5.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v6.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v7.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v8.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v9.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v10.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v11.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v12.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v13.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v14.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v15.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v16.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v17.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v18.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v19.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v20.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v21.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v22.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v23.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v24.lscache6.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v1.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v2.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v3.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v4.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v5.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v6.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v7.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v8.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v9.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v10.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v11.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v12.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v13.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v14.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v15.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v16.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v17.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v18.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v19.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v20.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v21.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v22.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v23.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v24.lscache7.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v1.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v2.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v3.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v4.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v5.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v6.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v7.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v8.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v9.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v10.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v11.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v12.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v13.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v14.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v15.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v16.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v17.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v18.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v19.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v20.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v21.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v22.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v23.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% v24.lscache8.c.youtube.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts

echo %IP% docs.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% docs0.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% docs1.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% docs2.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% spreadsheets.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% spreadsheets0.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% spreadsheets1.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% spreadsheets2.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% writely-china.l.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% writely.l.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts

echo %IP% maps.gstatic.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% maps.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% khm.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% mt0.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% mt1.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% mt2.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% mt.l.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts

echo %IP% code.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts

echo %IP% apps.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% finance.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% feedproxy.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% feeds.feedburner.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% feedburner.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% news.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts
echo %IP% video.google.com #THISISNOTE >>%windir%\System32\drivers\etc\hosts


echo.
echo.
echo.

echo 您的hosts编辑完成.
echo.
echo.

echo 请使用https方式访问Google+，地址是：
echo https://plus.google.com
echo.
pause

exit

:remove
cls
if exist "%windir%\System32\drivers\etc\hosts_hpbak" (goto removeit) else echo 备份文件不存在。您之前卸载过了吧？
goto begin

:removeit
ren %windir%\System32\drivers\etc\hosts hosts_del
ren %windir%\System32\drivers\etc\hosts_hpbak hosts
cls
del %windir%\System32\drivers\etc\hosts_del /s /q
goto begin

:edithosts
start %windir%\notepad.exe %windir%\system32\drivers\etc\hosts
cls
goto tools

:echoip
echo 稍等...
for /f "tokens=2 delims=[]" %%i in ('ping gpcom.azlyfox.com') do set IP=%%i
echo %IP%
pause
goto tools

:showip
ipconfig /flushdns
for /f "tokens=2 delims=[]" %%i in ('ping plus.google.com') do set IP=%%i
echo plus.google.com %IP%
pause
goto tools

:exit
exit
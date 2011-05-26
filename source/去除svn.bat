@echo On
@Rem É¾³ýSVN°æ±¾¿ØÖÆÄ¿Â¼
@PROMPT [Com]

@for /r . %%a in (.) do @if exist "%%a\.svn" rd /s /q "%%a\.svn"
@Rem for /r . %%a in (.) do @if exist "%%a\.svn" @echo "%%a\.svn"

@for /r . %%a in (.) do @if exist "%%a\.svn" rd /s /q "%%a\_svn"
@Rem for /r . %%a in (.) do @if exist "%%a\.svn" @echo "%%a\_svn"

@echo Mission Completed.
@pause
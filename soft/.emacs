;;;基本全局配置开始
(setq inhibit-startup-message t);关闭Emacs的默认启动界面
(setq initial-scratch-message nil);关闭scratch消息提示
(setq default-major-mode 'text-mode);一打开就起用 text 模式。
(global-font-lock-mode t);语法高亮
(auto-image-file-mode t);打开图片显示功能
(column-number-mode t);显示列号
(show-paren-mode t);显示括号匹配
(display-time-mode 1);显示时间，格式如下
(setq display-time-24hr-format t)
(setq display-time-day-and-date t)
;;(tool-bar-mode nil);去掉那个大大的工具栏
(tool-bar-mode 0)
(menu-bar-mode nil);去掉菜单栏
(scroll-bar-mode nil);去掉滚动条，因为可以使用鼠标滚轮了 ^_^
;;改变emacs标题栏的标题,显示buffer的名字
(setq frame-title-format "Lord@%b")
(mouse-avoidance-mode 'animate);光标靠近鼠标指针时，让鼠标指针自动让开，别挡住视线。很好玩阿，这个功能
(setq mouse-yank-at-point t);支持中键粘贴
(transient-mark-mode t);高亮显示要拷贝的区域
(setq x-select-enable-clipboard t);支持emacs和外部程序的粘贴
(setq visible-bell t);不要打入 TAB 时总是听到 PC 喇叭嘀嘀嘀的叫
(fset 'yes-or-no-p 'y-or-n-p);不要总是没完没了的问yes or no, 为什么不能用 y/n
(setq-default make-backup-files nil);不要生成临时文件
;;启动Emacs Server,然后用emacsclient起动emacs
;;加快emacs的起动速度
(server-start)
;;自动重载更改的文件
(global-auto-revert-mode 1)
;;{{{ 删除一些临时的buffers，少占我的内存
(defvar my-clean-buffers-names
  '("\\*Completions" "\\*Compile-Log" "\\*.*[Oo]utput\\*$"
    "\\*Apropos" "\\*compilation" "\\*Customize" "\\*Calc""\\keywiz-scores"
    "\\*BBDB\\*" "\\*trace of SMTP" "\\*vc" "\\*cvs" "\\*keywiz"
    "\\*WoMan-Log" "\\*tramp" "\\*desktop\\*" ;;"\\*Async Shell Command"
    )
  "List of regexps matching names of buffers to kill.")

(defvar my-clean-buffers-modes
  '(help-mode );Info-mode)
  "List of modes whose buffers will be killed.")

(defun my-clean-buffers ()
  "Kill buffers as per `my-clean-buffer-list' and `my-clean-buffer-modes'."
  (interactive)
  (let (string buffname)
    (mapcar (lambda (buffer)
              (and (setq buffname (buffer-name buffer))
                   (or (catch 'found
                         (mapcar '(lambda (name)
                                    (if (string-match name buffname)
                                        (throw 'found t)))
                                 my-clean-buffers-names)
                         nil)
                       (save-excursion
                         (set-buffer buffname)
                         (catch 'found
                           (mapcar '(lambda (mode)
                                      (if (eq major-mode mode)
                                          (throw 'found t)))
                                   my-clean-buffers-modes)
                           nil)))
                   (kill-buffer buffname)
                   (setq string (concat string
                                        (and string ", ") buffname))))
            (buffer-list))
    (if string (message "清理buffer: %s" string)
    ;(if string (message "Deleted: %s" string)
       (message "没有多余的buffer"))))
      ;(message "No buffers deleted"))))
;;}}}


(defun comment-dwim-line (&optional arg) 
"Replacement for the comment-dwim command." 
(interactive "*P") 
(comment-normalize-vars) 
(if (and (not (region-active-p)) (not (looking-at "[ \t]*$"))) 
(comment-or-uncomment-region (line-beginning-position) (line-end-position)) 
(comment-dwim arg)))

(load-file "C:/Emacs/site-lisp/htmlize.el")
(require 'htmlize)
(load-file "C:/Emacs/site-lisp/color-theme.el")
(color-theme-gnome2)
;; iimage mode
(autoload 'iimage-mode "iimage" "Support Inline image minor mode." t)
(autoload 'turn-on-iimage-mode "iimage" "Turn on Inline image minor mode." t)
(defun org-toggle-iimage-in-org ()
  "display images in your org file"
  (interactive)
  (if (face-underline-p 'org-link)
      (set-face-underline-p 'org-link nil)
      (set-face-underline-p 'org-link t))
  (iimage-mode))
  
(require 'tabbar)
(tabbar-mode)
(load-file "C:/Emacs/site-lisp/plantuml-mode.el")
(add-to-list 'auto-mode-alist '("\\.uml\\'" . plantuml-mode))
(autoload 'plantuml-mode "plantuml-mode" "PlantUML mode" t)

(defun plantuml-execute ()
  (interactive)
  (when (buffer-modified-p)
    (map-y-or-n-p "Save this buffer before executing PlantUML?"
                  'save-buffer (list (current-buffer))))
  (let ((code (buffer-string))
        out-file
        cmd)
    (when (string-match "^\\s-*@startuml\\s-+\\(\\S-+\\)\\s*$" code)
      (setq out-file (match-string 1 code)))
    (setq cmd (concat
               "java -jar " plantuml-java-options " "
               (shell-quote-argument plantuml-jar-path) " "
               (and out-file (concat "-t" (file-name-extension out-file))) " "
               plantuml-options " "
               (buffer-file-name)))
    (message cmd)
    (shell-command cmd)
    (message "done")))

(setq plantuml-jar-path "c:/Emacs/site-lisp/java/plantuml.jar")
(setq plantuml-java-options "")
(setq plantuml-options "-charset UTF-8")
(setq plantuml-mode-map
      (let ((map (make-sparse-keymap)))
        (define-key map (kbd "C-c C-c") 'plantuml-execute)
        map))
        
(load-file "C:/Emacs/site-lisp/alpha-window.el")
(global-set-key [(f11)] 'loop-alpha)

;;;;自动补齐策略

(defun my-indent-or-complete ()
   (interactive)
   (if (looking-at "//>")
     (hippie-expand nil)
     (indent-for-tab-command))
)

(global-set-key [(control tab)] 'my-indent-or-complete)
(global-set-key [(meta ?/)] 'hippie-expand)
(autoload 'senator-try-expand-semantic "senator")

(setq hippie-expand-try-functions-list
      '(try-expand-dabbrev                 ; 搜索当前 buffer
        try-expand-dabbrev-visible         ; 搜索当前可见窗口
        try-expand-dabbrev-all-buffers     ; 搜索所有 buffer
        try-expand-dabbrev-from-kill       ; 从 kill-ring 中搜索
        ;;try-complete-file-name-partially   ; 文件名部分匹配
        try-complete-file-name             ; 文件名匹配
        try-expand-all-abbrevs             ; 匹配所有缩写词
        try-expand-list                    ; 补全一个列表
        try-expand-line                    ; 补全当前行
        try-complete-lisp-symbol-partially ; 部分补全 elisp symbol
        try-complete-lisp-symbol))         ; 补全 lisp symbol


;; Dot
(load-file "C:/Emacs/site-lisp/graphviz-dot-mode.el")
(autoload 'graphviz-dot-mode "graphviz-dot-mode" nil t)
(add-to-list 'auto-mode-alist '("\\.dot$" . graphviz-dot-mode))

;;输入左边的括号，就会自动补全右边的部分.包括(), "", [] , {} , 等等。
;;;F5：打开speedbar
(global-set-key [(f5)] 'speedbar)
(global-set-key [f4] 'kill-this-buffer);f4关闭当前buffer所显示的文件

(setq org-ditaa-jar-path "C:/Emacs/site-lisp/java/ditaa0_9.jar")
 (setq org-plantuml-jar-path "C:/Emacs/site-lisp/java/plantuml.jar")

 (add-hook 'org-babel-after-execute-hook 'org-display-inline-images)

 (setq org-babel-load-languages (quote ((emacs-lisp . t)
                                        (dot . t)
                                        (ditaa . t)
                                        (R . t)
                                        (python . t)
                                        (ruby . t)
                                        (gnuplot . t)
                                        (clojure . t)
                                        (sh . t)
                                        (ledger . t)
                                        (org . t)
                                        (plantuml . t)
                                        (latex . t))))

; Do not prompt to confirm evaluation
; This may be dangerous - make sure you understand the consequences
; of setting this -- see the docstring for details
(setq org-confirm-babel-evaluate nil)

 ;; 给org生成html添加css
 (defcustom org-export-html-style"<link rel=\"stylesheet\" type=\"text/css\" href=\"org.css\">" ""
	:group 'org-export-html
	:type 'string)
	
;;yasnippet
(load-file "c:/Emacs/site-lisp/yasnippet-bundle.elc")
(require 'yasnippet)
(setq yas/root-directory "~/.emacs.d/snippets")
        (yas/load-directory yas/root-directory)

(add-to-list 'load-path
             "C:/Emacs/site-lisp/yasnippet")
(require 'yasnippet) ;; not yasnippet-bundle
(yas/initialize)
(yas/load-directory "C:/Emacs/site-lisp/yasnippet/snippets")

;; End of dotemacs.

;;;fonts
(custom-set-variables
  ;; custom-set-variables was added by Custom.
  ;; If you edit it by hand, you could mess it up, so be careful.
  ;; Your init file should contain only one such instance.
  ;; If there is more than one, they won't work right.
 '(column-number-mode t)
 '(display-time-mode t)
 '(show-paren-mode t))
(custom-set-faces
  ;; custom-set-faces was added by Custom.
  ;; If you edit it by hand, you could mess it up, so be careful.
  ;; Your init file should contain only one such instance.
  ;; If there is more than one, they won't work right.
 '(default ((t (:inherit nil :stipple nil :background "darkslategrey" :foreground "wheat" :inverse-video nil :box nil :strike-through nil :overline nil :underline nil :slant normal :weight normal :height 105 :width normal :foundry "outline" :family "微软雅黑")))))
 ;; Show in mysql-mode with sql-mode
(setq sql-mysql-options '("-C" "-t" "-f" "-n"))
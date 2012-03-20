;;;����ȫ�����ÿ�ʼ
(setq inhibit-startup-message t);�ر�Emacs��Ĭ����������
(setq initial-scratch-message nil);�ر�scratch��Ϣ��ʾ
(setq default-major-mode 'text-mode);һ�򿪾����� text ģʽ��
(global-font-lock-mode t);�﷨����
(auto-image-file-mode t);��ͼƬ��ʾ����
(column-number-mode t);��ʾ�к�
(show-paren-mode t);��ʾ����ƥ��
(display-time-mode 1);��ʾʱ�䣬��ʽ����
(setq display-time-24hr-format t)
(setq display-time-day-and-date t)
;;(tool-bar-mode nil);ȥ���Ǹ����Ĺ�����
(tool-bar-mode 0)
(menu-bar-mode nil);ȥ���˵���
(scroll-bar-mode nil);ȥ������������Ϊ����ʹ���������� ^_^
;;�ı�emacs�������ı���,��ʾbuffer������
(setq frame-title-format "Lord@%b")
(mouse-avoidance-mode 'animate);��꿿�����ָ��ʱ�������ָ���Զ��ÿ�����ס���ߡ��ܺ��氢���������
(setq mouse-yank-at-point t);֧���м�ճ��
(transient-mark-mode t);������ʾҪ����������
(setq x-select-enable-clipboard t);֧��emacs���ⲿ�����ճ��
(setq visible-bell t);��Ҫ���� TAB ʱ�������� PC ���������ֵĽ�
(fset 'yes-or-no-p 'y-or-n-p);��Ҫ����û��û�˵���yes or no, Ϊʲô������ y/n
(setq-default make-backup-files nil);��Ҫ������ʱ�ļ�
;;�Զ����ظ��ĵ��ļ�
(global-auto-revert-mode 1)
;;{{{ ɾ��һЩ��ʱ��buffers����ռ�ҵ��ڴ�
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
    (if string (message "����buffer: %s" string)
    ;(if string (message "Deleted: %s" string)
       (message "û�ж����buffer"))))
      ;(message "No buffers deleted"))))
;;}}}

(setq  load-path  (cons  "C:/Emacs/site-lisp"  load-path))

(defun comment-dwim-line (&optional arg) 
"Replacement for the comment-dwim command." 
(interactive "*P") 
(comment-normalize-vars) 
(if (and (not (region-active-p)) (not (looking-at "[ /t]*$"))) 
(comment-or-uncomment-region (line-beginning-position) (line-end-position)) 
(comment-dwim arg)))


(load-file "C:/Emacs/site-lisp/htmlize.elc")
(require 'htmlize)
(load-file "C:/Emacs/site-lisp/color-theme.elc")
(color-theme-aalto-light)

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
  
(load-file "C:/Emacs/lisp/cedet/pulse.elc")
(load-file "C:/Emacs/site-lisp/org-export-blocks-format-plantuml.el")
;;��ʾ�к�
(load-file "C:/Emacs/site-lisp/linum.elc")
(require 'linum)
(global-linum-mode t)

(load-file "C:/Emacs/site-lisp/highlight-tail.elc")
 (load-file "C:/Emacs/site-lisp/js2-mode.el")
(load-file "C:/Emacs/site-lisp/tabbar.elc")
(require 'tabbar)
(tabbar-mode)

(load-file "C:/Emacs/site-lisp/alpha-window.el")
(global-set-key [(f11)] 'loop-alpha)

(require 'auto-complete-config)
(add-to-list 'ac-dictionary-directories "c:/Emacs/site-lisp/ac-dict")
(ac-config-default)

;;;;�Զ��������

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
      '(try-expand-dabbrev                 ; ������ǰ buffer
        try-expand-dabbrev-visible         ; ������ǰ�ɼ�����
        try-expand-dabbrev-all-buffers     ; �������� buffer
        try-expand-dabbrev-from-kill       ; �� kill-ring ������
        ;;try-complete-file-name-partially   ; �ļ�������ƥ��
        try-complete-file-name             ; �ļ���ƥ��
        try-expand-all-abbrevs             ; ƥ��������д��
        try-expand-list                    ; ��ȫһ���б�
        try-expand-line                    ; ��ȫ��ǰ��
        try-complete-lisp-symbol-partially ; ���ֲ�ȫ elisp symbol
        try-complete-lisp-symbol))         ; ��ȫ lisp symbol


;; Dot
(load-file "C:/Emacs/site-lisp/graphviz-dot-mode.el")
(autoload 'graphviz-dot-mode "graphviz-dot-mode" nil t)
(add-to-list 'auto-mode-alist '("\\.dot$" . graphviz-dot-mode))

;;������ߵ����ţ��ͻ��Զ���ȫ�ұߵĲ���.����(), "", [] , {} , �ȵȡ�
;;;F5����speedbar
(global-set-key [(f5)] 'speedbar)
(global-set-key [f4] 'kill-this-buffer);f4�رյ�ǰbuffer����ʾ���ļ�

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

 ;; ��org����html���css
 (defcustom org-export-html-style"<link rel=\"stylesheet\" type=\"text/css\" href=\"org.css\">" ""
	:group 'org-export-html
	:type 'string)
(setq org-return-follows-link t)
	
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

(load-file "C:/Emacs/site-lisp/espresso.elc")
(autoload #'espresso-mode "espresso" "Start espresso-mode" t)
(add-to-list 'auto-mode-alist '("\\.js$" . espresso-mode))
(add-to-list 'auto-mode-alist '("\\.json$" . espresso-mode))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Gnus
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Googlize Me
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(set-fontset-font (frame-parameter nil 'font)
              'unicode '("AR PL KaitiM GB" . "unicode-bmp")) ;To use this font, aptitude isnatll ttf-arphic-gkai00mp

 ;;;;;;;;;;;;;;;;;;;;
 ;;   ���������趨
 ;;;;;;;;;;;;;;;;;;;;
(setq gnus-select-method '(nntp "news.newsfan.net"))  ;;�·�
(gnus-agentize)     ;;����������,Ϊ������gnus֧���������,gnus 5.10.x���Զ������ù��ܡ�

(setq user-full-name "emacsers")
(setq user-mail-address "emacsers@gmail.com")

;; SMTP
(setq message-send-mail-function 'smtpmail-send-it)
(setq smtpmail-default-smtp-server "smtp.gmail.com")
(setq smtpmail-smtp-service 587)
(setq smtpmail-starttls-credentials
'(("smtp.gmail.com"
587
nil
nil)))
(setq smtpmail-auth-credentials
'(("smtp.gmail.com"
587
"emacsers@gmail.com"
nil)))
;; IMAP - To use Gmail's IMAP access: Sign in to your account, Settings --> Forwarding and POP/IMAP --> Enable IMAP
(setq gnus-select-methods
      '((nnimap "imap.gmail.com"
                (nnimap-address "imap.gmail.com")
                (nnimap-server-port 993)
                (nnimap-stream ssl))))
(setq nnimap-split-inbox '("INBOX"))
(setq nnimap-split-rule 'nnmail-split-fancy)
(setq gnus-parameters
      '(("nnimap+imap.gmail.com.*" (gcc-self . t))))
(setq gnus-fetch-old-headers t)


(setq user-full-name "emacsers") 
(setq user-mail-address "emacsers@gmail.com") 
(setq gnus-select-method '(nntp "news.newsfan.net"))




;;;;;;;;;;;;;;;;;;;;
;;   ���Ի����趨
;;;;;;;;;;;;;;;;;;;;
(set-language-environment 'Chinese-GB)
(setq gnus-default-charset 'chinese-iso-8bit
      gnus-group-name-charset-group-alist '((".*" . cn-gb-2312))
      gnus-summary-show-article-charset-alist
      '((1 . cn-gb-2312)
	(2 . gb18030)
	(3 . chinese-iso-8bit)
	(4 . gbk)
	(5 . big5)
	(6 . utf-8))
      gnus-newsgroup-ignored-charsets
      '(unknown-8bit x-unknown iso-8859-1))



;;;;;;;;;;;;;;;;;;;;
;;�Զ���ʾͼƬ
;;;;;;;;;;;;;;;;;;;;
(auto-image-file-mode)
(setq mm-inline-large-images t)
(add-to-list 'mm-attachment-override-types "image/*")


(setq gnus-posting-styles
      '((".*"
	 (name "emacsers")
	 (address "emacsers@gmail.com")
	 (signature "http://blog.csdn.net/sheismylife\n UBuntu11.10��Emacs+Gnus\n")
	 ))
)

;; ���������package 

(add-to-list 'load-path (expand-file-name "C:/Emacs/site-lisp/jdee-2.4.0.1/lisp"))
(add-to-list 'load-path (expand-file-name "C:/Emacs/site-lisp/cedet-1.0beta3b/common"))
(load-file (expand-file-name "C:/Emacs/site-lisp/cedet-1.0beta3b/common/cedet.el"))
(add-to-list 'load-path (expand-file-name "C:/Emacs/site-lisp/elib-1.0")) 
;;(add-to-list 'load-path (eXPand-file-name "C:/Emacs/site-lisp/cedet-1.0beta3b/semantic")) 
;;(add-to-list 'load-path (expand-file-name "C:/Emacs/site-lisp/cedet-1.0beta3b/speedbar")) 
;;(add-to-list 'load-path (expand-file-name "C:/Emacs/site-lisp/cedet-1.0beta3b/eieio")) 
(require 'jde)
(setq jde-jdk-registry
      '(("1.6.0" . "C:/Program Files/Java/jdk1.6.0_22")))
(setq jde-jdk '("1.6.0"))
;;(setq jde-jdk-doc-url "file:///usr/local/jdk1.6.0_11/docs/index.html")
(setq jde-enable-abbrev-mode t)
;; End of dotemacs.

 ;; Show in mysql-mode with sql-mode
(setq sql-mysql-options '("-C" "-t" "-f" "-n"))
(custom-set-faces
 ;; custom-set-faces was added by Custom.
 ;; If you edit it by hand, you could mess it up, so be careful.
 ;; Your init file should contain only one such instance.
 ;; If there is more than one, they won't work right.
 '(default ((t (:inherit nil :stipple nil :background "#FFFFE0" :foreground "black" :inverse-video nil :box nil :strike-through nil :overline nil :underline nil :slant normal :weight normal :height 98 :width normal :foundry "outline" :family "΢���ź�")))))

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
(mouse-avoidance-mode 'animate);��꿿�����ָ��ʱ�������ָ���Զ��ÿ�����ס���ߡ��ܺ��氢���������
(setq mouse-yank-at-point t);֧���м�ճ��
(transient-mark-mode t);������ʾҪ����������
(setq x-select-enable-clipboard t);֧��emacs���ⲿ�����ճ��
(setq visible-bell t);��Ҫ���� TAB ʱ�������� PC ���������ֵĽ�
(fset 'yes-or-no-p 'y-or-n-p);��Ҫ����û��û�˵���yes or no, Ϊʲô������ y/n
(setq-default make-backup-files nil);��Ҫ������ʱ�ļ�
(load-file "C:/Emacs/site-lisp/htmlize.elc")
(require 'htmlize)
(load-file "C:/Emacs/site-lisp/color-theme.elc")
(color-theme-gnome2)
(load-file "C:/Emacs/site-lisp/psvn.el")
(require 'psvn)
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

(autoload 'senator-try-expand-semantic "senator")

(setq hippie-expand-try-functions-list
     '(
        senator-try-expand-semantic
        try-expand-dabbrev
        try-expand-dabbrev-visible
        try-expand-dabbrev-all-buffers
        try-expand-dabbrev-from-kill
        try-expand-list
        try-expand-list-all-buffers
        try-expand-line
        try-expand-line-all-buffers
        try-complete-file-name-partially
        try-complete-file-name
        try-expand-whole-kill
        )
)

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
 '(default ((t (:inherit nil :stipple nil :background "darkslategrey" :foreground "wheat" :inverse-video nil :box nil :strike-through nil :overline nil :underline nil :slant normal :weight normal :height 105 :width normal :foundry "outline" :family "΢���ź�")))))

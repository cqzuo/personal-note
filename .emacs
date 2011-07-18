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
(load-file "C:/Emacs/site-lisp/alpha-window.el")
(global-set-key [(f11)] 'loop-alpha)


(dolist (hook (list
               'c-mode-hook
               'emacs-lisp-mode-hook
               'lisp-interaction-mode-hook
               'lisp-mode-hook
               'emms-playlist-mode-hook
               'java-mode-hook
               'asm-mode-hook
               'haskell-mode-hook
               'rcirc-mode-hook
               'emms-lyrics-mode-hook
               'erc-mode-hook
               'sh-mode-hook
               'makefile-gmake-mode-hook
			   'lua-mode-hook
			   'python-mode-hook
			   'cmake-mode-hook
			   'php-mode-hook
               ))
  (add-hook hook (lambda () (linum-mode 1))))

(provide 'init-linum)
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
(load-file "C:/Emacs/site-lisp/my-word-complete.el")
(require 'my-word-complete)
(tabbar-mode)

(add-to-list 'load-path "C:/Emacs/site-lisp/auto-complete-1.3/")
(require 'auto-complete-config)
(add-to-list 'ac-dictionary-directories "C:/Emacs/site-lisp/auto-complete-1.3/dict")
(ac-config-default)

(define-key ac-complete-mode-map "/C-n" 'ac-next)
(define-key ac-complete-mode-map "/C-p" 'ac-previous)
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

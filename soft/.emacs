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
;;����Emacs Server,Ȼ����emacsclient��emacs
;;�ӿ�emacs�����ٶ�
(server-start)
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
 '(default ((t (:inherit nil :stipple nil :background "darkslategrey" :foreground "wheat" :inverse-video nil :box nil :strike-through nil :overline nil :underline nil :slant normal :weight normal :height 105 :width normal :foundry "outline" :family "΢���ź�")))))
 ;; Show in mysql-mode with sql-mode
(setq sql-mysql-options '("-C" "-t" "-f" "-n"))
Log4jのSyslogAppenderを拡張してマルチバイト文字列をsyslogに送れるようにしたもの。

オリジナルのLog4j-1.2.15からの変更点:
  1) syslogサーバへの送信文字コードの指定ができるようにしている。
  2) 例外時のスタックスレースの送信有無をlog4jの設定で強制できるようにしている。
  3) 送信文字コードでバイト化した1024バイト単位で文字列を分割している。

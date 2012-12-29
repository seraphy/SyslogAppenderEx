package org.apache.log4j.log4jextend.net;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class SyslogTest {

	private static final Log log = LogFactory.getLog(SyslogTest.class);
	
	public static void main(String[] args) throws Exception {
	    // メッセージテスト
        log.trace("テストメッセージ(TRACE)");
        log.debug("テストメッセージ(DEBUG)");
		log.info("テストメッセージ(INFO)");
		log.warn("テストメッセージ(WARN)");
		log.error("予期せぬ例外が発生しました。");
		
		// 例外オブジェクトをもつテスト
		// (log4jの設定により、例外送信を無効化できる.)
		RuntimeException e = new RuntimeException("予期せぬ例外が発生しました。");
		log.error("テスト例外", e);

		// 長いメッセージのテスト
		// (1024バイトで分割される。マルチバイトの考慮あり。)
		StringBuilder longmes = new StringBuilder();
		char c = 'あ';
        longmes.append(">>[START]");
		for (int idx = 0; idx < 2048; idx++) {
		    if (idx % 100 == 0) {
		        longmes.append(idx);
		    } else {
                longmes.append((char)(c + idx % 70));
		    }
		}
		longmes.append("[END]<<");
        log.error("longmes=" + longmes);
		
		System.out.println("done");
	}
       
}

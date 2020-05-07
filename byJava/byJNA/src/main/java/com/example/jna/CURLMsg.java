package com.example.jna;
import com.example.jna.Libcurl4Library.CURL;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : include\curl\multi.h:96</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class CURLMsg extends Structure {
	/**
	 * @see CURLMSG<br>
	 * what this message means<br>
	 * C type : CURLMSG
	 */
	public int msg;
	/**
	 * the handle it concerns<br>
	 * C type : CURL*
	 */
	public CURL easy_handle;
	/** C type : data_union */
	public data_union data;
	/** <i>native declaration : include\curl\multi.h:99</i> */
	public static class data_union extends Union {
		/**
		 * message-specific data<br>
		 * C type : void*
		 */
		public Pointer whatever;
		/**
		 * @see CURLcode<br>
		 * return code for transfer<br>
		 * C type : CURLcode
		 */
		public int result;
		public data_union() {
			super();
		}
		/**
		 * @param whatever message-specific data<br>
		 * C type : void*
		 */
		public data_union(Pointer whatever) {
			super();
			this.whatever = whatever;
			setType(Pointer.class);
		}
		/**
		 * @param result @see CURLcode<br>
		 * return code for transfer<br>
		 * C type : CURLcode
		 */
		public data_union(int result) {
			super();
			this.result = result;
			setType(Integer.TYPE);
		}
		public static class ByReference extends data_union implements Structure.ByReference {
			
		};
		public static class ByValue extends data_union implements Structure.ByValue {
			
		};
	};
	public CURLMsg() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("msg", "easy_handle", "data");
	}
	/**
	 * @param msg @see CURLMSG<br>
	 * what this message means<br>
	 * C type : CURLMSG<br>
	 * @param easy_handle the handle it concerns<br>
	 * C type : CURL*<br>
	 * @param data C type : data_union
	 */
	public CURLMsg(int msg, CURL easy_handle, data_union data) {
		super();
		this.msg = msg;
		this.easy_handle = easy_handle;
		this.data = data;
	}
	public static class ByReference extends CURLMsg implements Structure.ByReference {
		
	};
	public static class ByValue extends CURLMsg implements Structure.ByValue {
		
	};
}

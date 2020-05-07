package com.example.jna;
import com.example.jna.Libcurl4Library.time_t;
import com.ochafik.lang.jnaerator.runtime.NativeSize;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * Information about a single file, used when doing FTP wildcard matching<br>
 * <i>native declaration : include\curl\curl.h:227</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class curl_fileinfo extends Structure {
	/** C type : char* */
	public Pointer filename;
	/**
	 * @see curlfiletype<br>
	 * C type : curlfiletype
	 */
	public int filetype;
	/**
	 * always zero!<br>
	 * C type : time_t
	 */
	public time_t time;
	public int perm;
	public int uid;
	public int gid;
	/** C type : curl_off_t */
	public NativeLong size;
	public NativeLong hardlinks;
	/** C type : strings_struct */
	public strings_struct strings;
	public int flags;
	/**
	 * used internally<br>
	 * C type : char*
	 */
	public Pointer b_data;
	public NativeSize b_size;
	public NativeSize b_used;
	/** <i>native declaration : include\curl\curl.h:237</i> */
	public static class strings_struct extends Structure {
		/**
		 * If some of these fields is not NULL, it is a pointer to b_data.<br>
		 * C type : char*
		 */
		public Pointer time;
		/** C type : char* */
		public Pointer perm;
		/** C type : char* */
		public Pointer user;
		/** C type : char* */
		public Pointer group;
		/**
		 * pointer to the target filename of a symlink<br>
		 * C type : char*
		 */
		public Pointer target;
		public strings_struct() {
			super();
		}
		protected List<String> getFieldOrder() {
			return Arrays.asList("time", "perm", "user", "group", "target");
		}
		/**
		 * @param time If some of these fields is not NULL, it is a pointer to b_data.<br>
		 * C type : char*<br>
		 * @param perm C type : char*<br>
		 * @param user C type : char*<br>
		 * @param group C type : char*<br>
		 * @param target pointer to the target filename of a symlink<br>
		 * C type : char*
		 */
		public strings_struct(Pointer time, Pointer perm, Pointer user, Pointer group, Pointer target) {
			super();
			this.time = time;
			this.perm = perm;
			this.user = user;
			this.group = group;
			this.target = target;
		}
		public static class ByReference extends strings_struct implements Structure.ByReference {
			
		};
		public static class ByValue extends strings_struct implements Structure.ByValue {
			
		};
	};
	public curl_fileinfo() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("filename", "filetype", "time", "perm", "uid", "gid", "size", "hardlinks", "strings", "flags", "b_data", "b_size", "b_used");
	}
	public static class ByReference extends curl_fileinfo implements Structure.ByReference {
		
	};
	public static class ByValue extends curl_fileinfo implements Structure.ByValue {
		
	};
}

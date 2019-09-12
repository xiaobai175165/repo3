package cn.kgc.tangcco.zhongjiban.util;
import java.util.*;
public abstract class UuidCode {
	public static String getUuid() {
		return UUID.randomUUID().toString();
	}
}

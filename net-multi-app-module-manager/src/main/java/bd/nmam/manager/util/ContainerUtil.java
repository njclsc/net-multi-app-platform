package bd.nmam.manager.util;

import java.text.SimpleDateFormat;

public class ContainerUtil {
	private static SimpleDateFormat sdfStand = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static SimpleDateFormat getSdfStand() {
		return sdfStand;
	}

	public static void setSdfStand(SimpleDateFormat sdfStand) {
		ContainerUtil.sdfStand = sdfStand;
	}
}

package top.sob.idp.mirrors;

import java.util.Set;

public class ZhCnMirror extends AbstractMirror {

    private static final Set<String> ZH_CN_MIRRORS = Set.of("https://maven.aliyun.com/repository/gradle-plugin",
            "https://maven.aliyun.com/repository/central",
            "https://maven.aliyun.com/repository/public",
            "https://maven.aliyun.com/repository/google");

    private static final ZhCnMirror INSTANCE = new ZhCnMirror();

    public static ZhCnMirror getInstance() {
        return INSTANCE;
    }

    private ZhCnMirror() {
        super(ZH_CN_MIRRORS);
    }

}

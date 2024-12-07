package top.sob.vanilla.models.auth.passcode;

import org.jetbrains.annotations.NotNull;

import top.sob.core.Meta;
import top.sob.core.utils.SecurityUtils;

import java.io.Serializable;

import java.security.MessageDigest;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PasscodeDatabase extends HashMap<String, String> implements Serializable {

    private static final PasscodeDatabase DEFAULT = new PasscodeDatabase(SecurityUtils.getDefaultMessageDigest());

    private final MessageDigest digest;

    public PasscodeDatabase(@NotNull MessageDigest digest) {

        Objects.requireNonNull(digest);

        this.digest = digest;
    }

    public static PasscodeDatabase getDefault() {
        return DEFAULT;
    }

    @Override
    public String put(String key, String value) {
        return super.put(key, Base64.getEncoder()
                .encodeToString(
                        getDigest().digest(
                                value.getBytes(Meta.DEF_CHARSET))));
    }

    public MessageDigest getDigest() {
        return digest;
    }

    public boolean contains(String username, String passcode) {
        return entrySet().contains(Map.entry(username, passcode));
    }
}

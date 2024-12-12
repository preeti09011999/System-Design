package Chess;

import java.util.UUID;

public class Account {
    private final String accountId;
    private final String name;
    private final String email;
    private final AccountStatus accountStatus;

    public Account(String name, String email) {
        this.accountId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.accountStatus = AccountStatus.ACTIVE;
    }
}

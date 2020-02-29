package com.hendisantika.springbootdddbank.domain;

import com.hendisantika.springbootdddbank.domain.base.EntityBase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ddd-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/03/20
 * Time: 06.49
 */
@Entity
public class AccountAccess extends EntityBase<AccountAccess> {
    @ManyToOne
    private Client client;

    private boolean isOwner;

    @ManyToOne
    private Account account;

    /**
     * Necessary for JPA entities internally.
     */
    @SuppressWarnings("unused")
    private AccountAccess() {
    }

    public AccountAccess(final Client client, final boolean isOwner, final Account account) {
        this.client = client;
        this.isOwner = isOwner;
        this.account = account;
    }

    /**
     * Returns the {@link Client} who is managing the {@link Account}.
     *
     * @return the linked {@link Client}
     */
    public Client getClient() {
        return client;
    }

    /**
     * Informs if the {@link Client} is the owner of the {@link Account}.
     *
     * @return true if the {@link Client} is the owner of the Account, but false if
     * he is only manager of the account.
     */
    public boolean isOwner() {
        return isOwner;
    }

    /**
     * Returns the {@link Account} accessible by this object.
     *
     * @return the {@link Account} accessible by this object
     */
    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return String.format("%s{client='%s', isOwner='%b', account='%s'}", getClass().getSimpleName(), client, isOwner,
                account);
    }
}

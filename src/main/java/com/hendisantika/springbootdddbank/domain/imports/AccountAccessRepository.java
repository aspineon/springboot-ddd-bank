package com.hendisantika.springbootdddbank.domain.imports;

import com.hendisantika.springbootdddbank.domain.AccountAccess;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ddd-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/03/20
 * Time: 07.09
 */
public interface AccountAccessRepository {
    /**
     * Deletes all {@link AccountAccess} objects. Linked {@link Client}s or
     * {@link Account}s must be deleted before.
     */
    void deleteAll();

    /**
     * Saves the passed object. Linked {@link Client} and {@link Account} must be
     * saved before.
     *
     * @param accountAccess the {@link AccountAccess} object to be saved
     * @return the saved instance
     */
    AccountAccess save(AccountAccess accountAccess);

    /**
     * Deletes the given {@link AccountAccess} object.
     *
     * @param accountAccess the AccountAccess object to be deleted
     */
    void delete(AccountAccess accountAccess);

}

/**
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mifosplatform.portfolio.loanaccount.guarantor.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GuarantorFundingTransactionRepository extends JpaRepository<GuarantorFundingTransaction, Long>,
        JpaSpecificationExecutor<GuarantorFundingTransaction> {

    @Query("from GuarantorFundingTransaction ft where ft.loanTransaction.id in (:loanTransactions)")
    List<GuarantorFundingTransaction> fetchGuarantorFundingTransactions(@Param("loanTransactions") List<Long> loanTransactions);

}
package com.example.account.dto;

import com.example.account.type.TransactionResultType;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * {
 * 	"transactionId":"c2033bb6d82a4250aecf8e27c49b63f6",
 * 	"accountNumber":"1000000000",
 * 	"amount":1000
 * }
 */
public class CancelBalance {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {
        @NotBlank
        private String transactionId;

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;

        @NotNull
        @Min(10) //최소 10원
        @Max(1000_000_000) //최대 10억
        private Long amount;
    }

    /**
     * {
     * 	"accountNumber":"1234567890",
     * 	"transactionResult":"S",
     * 	"transactionId":"c2033bb6d82a4250aecf8e27c49b63f6",
     * 	"amount":1000,
     * 	"transactedAt":"2022-06-01T23:26:14.671859"
     * }
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String accountNumber;
        private TransactionResultType transactionResult;
        private String transactionId;
        private Long amount;
        private LocalDateTime transactedAt;

        public static Response from(TransactionDTO transactionDTO) {
            return Response.builder()
                    .accountNumber(transactionDTO.getAccountNumber())
                    .transactionResult(transactionDTO.getTransactionResult())
                    .transactionId(transactionDTO.getTransactionId())
                    .amount(transactionDTO.getAmount())
                    .transactedAt(transactionDTO.getTransactedAt())
                    .build();
        }
    }
}

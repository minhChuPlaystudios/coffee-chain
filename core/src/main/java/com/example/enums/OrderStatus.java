package com.example.enums;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
public enum OrderStatus {
    IN_QUEUE,
    PREPARING, // Still in queue
    CANCELLED,
    READY, // Ready to delivery and remove from queue
    DELIVERED
}

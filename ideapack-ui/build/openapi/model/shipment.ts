/**
 * Ideapack API
 * This is an API of Ideapack services.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


export interface Shipment { 
    id?: string;
    /**
     * The delivery address
     */
    trackingData?: string;
    shipmentId?: string;
    /**
     * Shipping Status
     */
    status?: string;
    lastUpdate?: string;
    /**
     * The Sender name
     */
    sender?: string;
    /**
     * The Pickup location
     */
    pickupLocation?: string;
    deliveryEstimate?: string;
    /**
     * The Recipient name
     */
    recipient?: string;
    /**
     * The Recipient phone number
     */
    recipientPhone?: string;
    /**
     * The delivery address
     */
    destination?: string;
    deliveryDate?: string;
    shippingPrice?: number;
}


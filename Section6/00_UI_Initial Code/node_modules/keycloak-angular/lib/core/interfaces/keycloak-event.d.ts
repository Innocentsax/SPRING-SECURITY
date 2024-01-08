export declare enum KeycloakEventType {
    OnAuthError = 0,
    OnAuthLogout = 1,
    OnAuthRefreshError = 2,
    OnAuthRefreshSuccess = 3,
    OnAuthSuccess = 4,
    OnReady = 5,
    OnTokenExpired = 6,
    OnActionUpdate = 7
}
export interface KeycloakEvent {
    type: KeycloakEventType;
    args?: unknown;
}

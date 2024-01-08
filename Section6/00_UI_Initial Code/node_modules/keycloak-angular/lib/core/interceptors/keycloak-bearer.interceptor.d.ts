import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { KeycloakService } from '../services/keycloak.service';
import * as i0 from "@angular/core";
export declare class KeycloakBearerInterceptor implements HttpInterceptor {
    private keycloak;
    constructor(keycloak: KeycloakService);
    private conditionallyUpdateToken;
    private isUrlExcluded;
    intercept(req: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>>;
    private handleRequestWithTokenHeader;
    static ɵfac: i0.ɵɵFactoryDeclaration<KeycloakBearerInterceptor, never>;
    static ɵprov: i0.ɵɵInjectableDeclaration<KeycloakBearerInterceptor>;
}

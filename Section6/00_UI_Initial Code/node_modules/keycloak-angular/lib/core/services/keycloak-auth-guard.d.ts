import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { KeycloakService } from './keycloak.service';
export declare abstract class KeycloakAuthGuard implements CanActivate {
    protected router: Router;
    protected keycloakAngular: KeycloakService;
    protected authenticated: boolean;
    protected roles: string[];
    constructor(router: Router, keycloakAngular: KeycloakService);
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean | UrlTree>;
    abstract isAccessAllowed(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean | UrlTree>;
}

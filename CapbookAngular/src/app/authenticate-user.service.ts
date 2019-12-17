import { Injectable } from '@angular/core';
import { CanActivate, RouteReuseStrategy, Router } from '@angular/router';
import { DetailsService } from './details.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateUserService implements CanActivate {

  canActivate(route: import("@angular/router").ActivatedRouteSnapshot, state: import("@angular/router").RouterStateSnapshot): boolean | import("@angular/router").UrlTree | import("rxjs").Observable<boolean | import("@angular/router").UrlTree> | Promise<boolean | import("@angular/router").UrlTree> {
    if (this.service.isUserLoggedIn())
    return true;
    
    this.route.navigate(['login']);
    
    return false;
    }
  

  constructor(private service:DetailsService,private route:Router) {}
}


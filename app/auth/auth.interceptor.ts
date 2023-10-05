import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    console.log("intercepting");
    //if login not checking jwt
    console.log(request.url);
    if (request.url.includes('api/users')) {
      console.log("Not checking");
    }
    //if JWT is there
    else {
      let token = localStorage.getItem("TOKEN");
      console.log(token)
     // console.log(localStorage.getItem('ACCESS_ROLE'));

      //CHECKING ACCESS ROLE AND JWT TOKEN
      if (localStorage.getItem('ROLE_ID') && (localStorage.getItem("TOKEN"))) {
        const newRequest = request.clone({
          setHeaders: {
            Authorization: `${token}`
          }
        });
        console.log(newRequest);

        return next.handle(newRequest);
      }

    }
    //else not authorized

    return next.handle(request);
  }
}

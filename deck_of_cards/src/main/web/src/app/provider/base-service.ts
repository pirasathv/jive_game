import 'rxjs/Rx';
import { Injector } from '@angular/core';
import { JiveInjector } from '../app.injector';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';

export class BaseService {

  private http: Http;

  constructor() {
    this.http = JiveInjector.instance.get(Http);
  }

  doGet(path) {
		let url = environment.systemUrl + path;
    return this.http
	    .get(url)
	    .map(this.mapHttpResult)
	    .toPromise();
	}

	mapHttpResult(res) {
		if (res.status == 200) {
      try {
        return res.json();
      } catch (e) {
        return res.text();
      }
    } else {
  		return res;
    }
	}
}

import { BrowserModule } from '@angular/platform-browser';
import { Injector } from '@angular/core';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { BaseService } from './provider/base-service';
import { DeckService } from './provider/deck-service';
import { JiveInjector } from './app.injector';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    HttpModule,
    BrowserModule
  ],
  providers: [
    BaseService,
    DeckService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
    constructor(private injector: Injector) {
    	 JiveInjector.instance = this.injector;
    }
}

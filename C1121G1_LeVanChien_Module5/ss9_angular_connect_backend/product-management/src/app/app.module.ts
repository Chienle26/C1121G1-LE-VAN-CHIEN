import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {SharedModule} from './shared/shared.module';
import {ProductModule} from './component/product/product.module';
import {CategoryModule} from './component/category/category.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    ProductModule,
    CategoryModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

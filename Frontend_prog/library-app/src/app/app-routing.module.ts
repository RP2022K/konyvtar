import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { KolcsonzokComponent } from './kolcsonzok/kolcsonzok.component';
import { KolcsonzesekComponent } from './kolcsonzesek/kolcsonzesek.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'kolcsonzok', component: KolcsonzokComponent },
  { path: 'kolcsonzesek', component: KolcsonzesekComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
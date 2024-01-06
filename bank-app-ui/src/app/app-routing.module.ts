import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactComponent } from './components/contact/contact.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AccountComponent } from '../app/components/account/account.component';
import { BalanceComponent } from '../app/components/balance/balance.component';
import { NoticesComponent } from './components/notices/notices.component';
import { LoansComponent } from './components/loans/loans.component';
import { CardsComponent } from './components/cards/cards.component';
import { AuthKeyClockGuard } from './routeguards/auth.route';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'notices', component: NoticesComponent},
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthKeyClockGuard],data: {
    
  }},
  { path: 'myAccount', component: AccountComponent, canActivate: [AuthKeyClockGuard],data: {
    roles: ['USER']
  }},
  { path: 'myBalance', component: BalanceComponent, canActivate: [AuthKeyClockGuard],data: {
    roles: ['USER','ADMIN']
  }},
  { path: 'myLoans', component: LoansComponent, canActivate: [AuthKeyClockGuard],data: {
    
  }},
  { path: 'myCards', component: CardsComponent, canActivate: [AuthKeyClockGuard],data: {
    roles: ['USER']
  }}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

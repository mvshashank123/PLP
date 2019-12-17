import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { FilterPipe } from './filter.pipe';
import { FriendRequestComponent } from './friend-request/friend-request.component';
import { ProfileUpdateComponent } from './profile-update/profile-update.component';
import { ChangeProfilePicComponent } from './change-profile-pic/change-profile-pic.component';
import { ViewPageComponent } from './view-page/view-page.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    UserprofileComponent,
    ChangePasswordComponent,
    ForgotPasswordComponent,
    FilterPipe,
    FriendRequestComponent,
    ProfileUpdateComponent,
    ChangeProfilePicComponent,
    ViewPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

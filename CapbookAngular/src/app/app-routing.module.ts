import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { FriendRequestComponent } from './friend-request/friend-request.component';
import { ChangeProfilePicComponent } from './change-profile-pic/change-profile-pic.component';
import { AuthenticateUserService } from './authenticate-user.service';
import { ViewPageComponent } from './view-page/view-page.component';


const routes: Routes = [
  {path:'register',component:RegisterComponent},
  {path:'',component:LoginComponent},
  {path:'userpage/:email',component:UserprofileComponent,canActivate:[AuthenticateUserService]},
  {path:'changepass',component:ChangePasswordComponent},
  {path:'forgotpass',component:ForgotPasswordComponent},
  {path:'requestList/:email',component:FriendRequestComponent,canActivate:[AuthenticateUserService]},
  {path:'changepic/:email',component:ChangeProfilePicComponent,canActivate:[AuthenticateUserService]},
  {path:'view/:email/:n',component:ViewPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

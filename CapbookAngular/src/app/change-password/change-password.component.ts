import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DetailsService } from '../details.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  constructor(private userService:DetailsService,private router:Router) { }

  newpass;
  confirmpass;

  user={
    email:'',
    password:''
  }

  /*changePassword() {
    if(this.newpass!=this.confirmpass){
      alert("password not matched")
    }else if(this.user.password==this.newpass){
      alert("New password is equal to old password. please put the new password")
    }
    else if(this.user.password==this.newpass){
      this.userService.change(this.user,this.newpass).subscribe(()=>{
        alert("Password Changed...")
        this.router.navigate([''])
      })
    }
    else{
      this.userService.login(this.user.email,this.user.password).subscribe(()=>{
        alert('logged in....')
        this.router.navigate(['userpage/'+this.email]);
        },(error) =>{
        console.log(error)
        alert("Failed")
        })
        alert('cannot get account...')
    }
  }*/
  changePassword()
  {
    this.userService.login(this.user.email,this.user.password).subscribe(()=>{
      if(this.newpass!=this.confirmpass){
        alert("password not matched")
      }
      else if(this.user.password==this.newpass){
        alert("New password is equal to old password. please put the new password")
      }
      else{
        this.userService.changePassword(this.user,this.newpass).subscribe(()=>{
          alert("Password Changed...")
          this.router.navigate([''])
        })
      }
    }
    ,(error) =>{
      console.log(error)
      alert("Account details are incorrect..")
      })
  }

  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';
import { DetailsService } from '../details.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  constructor(private userService:DetailsService,private router:Router) { }
  user={
    email:''
  }
  answer;
  newpass;
  ngOnInit() {
  }
forgot(){
  this.userService.checkByMail_Answer(this.user.email,this.answer).subscribe(()=>{
      this.userService.forgotPassword(this.user,this.newpass).subscribe(()=>{
        alert("Password Changed...")
        this.router.navigate([''])
      })
    }
  
  ,(error) =>{
    console.log(error)
    alert("Account details are incorrect..")
    })
}
}

import { Component, OnInit } from '@angular/core';
import { DetailsService } from '../details.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

   register={
     firstName:'',
     lastName:'',
     email:'',
     password:'',
     gender:'',
     phoneNumber:'',
     dob:'',
     sec_ques:''
   }
  constructor(private userService:DetailsService,private router:Router) { }

  ngOnInit() {
  }

  /*addUser()
  { 
        this.userService.save(this.register).subscribe(()=>{
          alert('added...')
          this.router.navigate([''])
      })
  }*/

  onSubmit(data) {
    this.userService.save(this.register).subscribe(()=>{
      alert('added...')
      this.router.navigate([''])
  })
}

}

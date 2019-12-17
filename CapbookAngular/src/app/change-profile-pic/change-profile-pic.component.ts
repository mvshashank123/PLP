import { Component, OnInit } from '@angular/core';
import { DetailsService } from '../details.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-change-profile-pic',
  templateUrl: './change-profile-pic.component.html',
  styleUrls: ['./change-profile-pic.component.css']
})
export class ChangeProfilePicComponent implements OnInit {

  pic={
    email:'',
    location:''
  }

  constructor(private service:DetailsService,private route:Router,private router:ActivatedRoute) {
    router.params.subscribe((parameters)=>this.pic.email=parameters['email'])
   }

  ngOnInit() {
  }

  addPic()
{
  this.service.addProfilePic(this.pic).subscribe(()=>{
    
    alert('added....')
  this.route.navigate(['userpage/',this.pic.email])
})
}

}

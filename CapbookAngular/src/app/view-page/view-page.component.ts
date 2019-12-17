import { Component, OnInit } from '@angular/core';
import { DetailsService } from '../details.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-page',
  templateUrl: './view-page.component.html',
  styleUrls: ['./view-page.component.css']
})
export class ViewPageComponent implements OnInit {
email1
email2
status
user

picture

  constructor(private service:DetailsService,private route:ActivatedRoute) {
    route.params.subscribe((parameters)=>{this.email1=parameters['email'],this.email2=parameters["n"]})
    service.check(this.email1,this.email2).subscribe((res)=>this.status=res)

    service.getProfilePic().subscribe((res)=>this.picture=res)

    service.getByEmail(this.email2).subscribe((res)=>this.user=res)
  }

  ngOnInit() {
  }


  
}

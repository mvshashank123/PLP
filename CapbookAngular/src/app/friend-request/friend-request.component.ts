import { Component, OnInit } from '@angular/core';
import { DetailsService } from '../details.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-friend-request',
  templateUrl: './friend-request.component.html',
  styleUrls: ['./friend-request.component.css']
})
export class FriendRequestComponent implements OnInit {

  userDetail

  email

  constructor(private service:DetailsService,private route:ActivatedRoute) {
    route.params.subscribe((parameters)=>this.email=parameters['email'])
    
  } 

  ngOnInit() {
  }

  getData()
  {
    this.service.getByEmail(this.email).subscribe((res)=>this.userDetail=res)
    this.service.getAllFriends(this.email).subscribe((res)=>this.userDetail=res)
  }

  requests;

  friendRequest(){
    this.service.getRequests(this.email).subscribe((res)=>this.requests=res)
  }

  friendList={
    fromName:'',
    toName:'',
    friendStatus:0
  }
  friend
  friends(){
    this.service.friends(this.email).subscribe((res)=>
    {
      this.friend=res;
    })
  }

  decline(r){

    this.service.remove(r,this.email).subscribe(()=>{
      alert("request deleted..")
      history.go()
    })

  }

  accept(r){
    this.friendList.toName=this.email;
    this.friendList.fromName=r;
    this.friendList.friendStatus=2;
    this.service.accept(r,this.friendList).subscribe(()=>{
      alert("friend request accepted")
      history.go()
    })
  }

  addFriend(event :any,to_name){
    event.target.disabled=true;
    
    this.friendList.fromName=this.email;
    //alert(this.username)
    this.friendList.toName=to_name;
    this.friendList.friendStatus=1;
    this.service.addFriendRequest(this.friendList).subscribe(()=>{
    alert("frined request sent to "+ to_name)
    })
}

}

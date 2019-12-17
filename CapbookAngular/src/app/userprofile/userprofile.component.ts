import { Component, OnInit } from '@angular/core';
import { DetailsService } from '../details.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {

  names={
    name:''
  }

  friendList={
    fromName:'',
    toName:'',
    friendStatus:0
  }
  //----for profile pic---
  picture

  //----for picture status--
  picStatus

//-------------
  email
  public details
  allUsers

  lnames;
  constructor(private service:DetailsService,private route:ActivatedRoute,private router:Router) {
    route.params.subscribe((parameters)=>this.email=parameters['email'])
    service.getByEmail(this.email).subscribe((res)=>this.details=res)
    service.getAllNames().subscribe((res)=>this.lnames=res)
    service.getProfilePic().subscribe((res)=>this.picture=res)
    service.getAllText().subscribe((res)=>this.posttextsReturn=res)
    service.getPictures().subscribe((res)=>this.picStatus=res)
    service.getAllComments().subscribe((res)=>this.postcommentsReturn=res)
    
   }

  ngOnInit() { 
  }

  logout()
  {
    this.service.logout()
    this.router.navigate([''])
  }

  show(){
    this.service.getAll().subscribe((res)=>this.allUsers=res)
  }

  addNames(){
    this.service.addNames(this.names).subscribe(()=>{alert("Status Updated")
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

request()
{
  this.router.navigateByUrl("/requestList/"+this.details.email)
}

//-----for status in text-----
posttexts={
  email:'',
  statusInText:''
}
posttextsReturn;

addPostInText(){
  this.posttexts.email=this.email
  this.service.addPostInText(this.posttexts).subscribe(()=>{ 
    history.go()
})
}

removeStatus(sid){
  this.service.removeStatus(sid).subscribe(()=>{
  history.go()})
}

//---------for picture status--------
pictureStatus={
  email:'',
  location:''
}
addPicture(){
  this.pictureStatus.email=this.email
  this.service.addPicture(this.pictureStatus).subscribe(()=>alert("posted"))
  history.go()
}
deletePicture(lid){
  this.service.deletePicture(lid).subscribe(()=>{
    history.go()})
}

//-----------for comments--------
postcomments={
  email:'',
  location:'',
  comments:''
}

postcommentsReturn;

addCommentInText(lid){
  this.postcomments.location=lid;
  this.postcomments.email=this.email;
  this.service.addCommentInText(this.postcomments).subscribe(()=>{ 
    history.go()
})
}
search
//---search---
nameList
searchName()
{
  this.service.searchName(this.search).subscribe((res)=>this.nameList=res)
}

}

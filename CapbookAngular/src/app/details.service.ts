import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DetailsService {

  private userUrl;

  constructor(private http:HttpClient) {
    this.userUrl='http://localhost:9002';
   }

   isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticateUser')
    return !(user === null)
    }

   public getAll()
   {
     return this.http.get(this.userUrl);
   }

   public getByEmail(email)
   {
     return this.http.get(this.userUrl+"/"+email)
   }
  
  public save(user) {
    return this.http.post(this.userUrl+"/add",user);
  }

  public login(email, password){
    if (this.http.get(this.userUrl+"/"+email+ '/' + password))
    sessionStorage.setItem('authenticateUser', email);
    return  this.http.get(this.userUrl+"/"+email+"/"+password);
  }

  logout() {
    sessionStorage.removeItem('authenticateUser')
    }
  //need to be checked
  public getAllNames(){
    return this.http.get(this.userUrl);
  }

  public addNames(name){
    return this.http.post(this.userUrl+"/addstatus",name);
  }
  //----------------------------
  public changePassword(user,newpass){

    return this.http.put(this.userUrl+'/'+user.email+'/'+newpass,user);
  }
  public checkByMail_Answer(email, answer){
    return this.http.get(this.userUrl+"/"+email+"/forgot/"+answer)
  }
  public forgotPassword(user,newpass){

    return this.http.put(this.userUrl+'/'+user.email+'/forgot/'+newpass,user);
  }
  //--friend request--
  addFriendRequest(friendList){
    return this.http.post(this.userUrl+"/addfriend",friendList);
  }

  getRequests(toName){
    return this.http.get(this.userUrl+"/addfriend"+"/"+toName)
  }

  remove(fromName,toName){
    return this.http.delete(this.userUrl+"/delete"+"/"+fromName+"/"+toName)
  }

  accept(fromName,friendList){
    return this.http.put(this.userUrl+"/accept"+"/"+fromName,friendList)
  }

  friends(name){
    return this.http.get(this.userUrl+"/getFriends"+"/"+name)
  }

  getAllFriends(email)
  {
    return this.http.get(this.userUrl+"/getAll"+"/"+email)
  }

  //-----for profile pic----
   getProfilePic()
   {
     return this.http.get(this.userUrl+"/profile")
   }

   addProfilePic(pic)
   {
     return this.http.post(this.userUrl+"/profile",pic)
   }

   //----for status in text---

   getAllText(){
    return this.http.get(this.userUrl+"/posttext")
  }

   addPostInText(posttext){
    return this.http.post(this.userUrl+"/posttext",posttext)
  }

  removeStatus(sid){
    return this.http.delete(this.userUrl+"/deletestatus"+"/"+sid)
  }
  //---------for picture status-----
  getPictures(){
    return this.http.get(this.userUrl+"/picture")
  }
  addPicture(pic){
  return this.http.post(this.userUrl+"/picture",pic)
  }
  deletePicture(lid) {
    return this.http.delete(this.userUrl+"/delete"+"/"+lid)
  }

  //-----------for comment------
  getAllComments() {
    return this.http.get(this.userUrl+"/comment")
  }
   
  addCommentInText(postcomments)

  {
    return this.http.post(this.userUrl+"/comment",postcomments)
  }

  //-------search---
  searchName(name)
  {
    return this.http.get(this.userUrl+"/search/"+name)
  }

  //-----view----
  check(email1,email2)
  {
    return this.http.get(this.userUrl+"/check/"+email1+"/"+email2)
  }

}

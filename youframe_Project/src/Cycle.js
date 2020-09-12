import React, { Component } from 'react'
import axios from 'axios';

export class Cycle extends Component {
    constructor(props) {
        super(props)
        this.state = {
            image: [],
            img:''
        }


    }
    componentDidMount() {

        axios.get('http://localhost:8080/YouFrame/MyImage').then(res => {
            console.log(res.data.result)
            this.setState({
                image: res.data.result
            })
            console.log(this.state.image)

        })
    }
    reload = () => {
        axios.get('http://localhost:8080/YouFrame/MyImage').then(res => {
            console.log(res.data.result)
            this.setState({
                image: res.data.result
            })

        })
    }

    
    onImageChange = (event) => {
        if (event.target.files && event.target.files[0]) {
          let reader = new FileReader();
          reader.onload = (e) => {
            this.setState({img: e.target.result});
            let Image = {image:this.state.img}
           
         axios.post('http://localhost:8080/YouFrame/AddImage', Image).then(res => {
           
           this.reload();
        }).catch(error => console.log(error))



            
            
          };
          reader.readAsDataURL(event.target.files[0]);
        
        }
        // this.Handle();
        
        
      }


    render() {
        if(this.state.image!=null)
        {
        return (
            <div>
                <div>
                    <center>
                    <button class="fileUpload">
                        <span ><img src="upload.svg" height="15px" width="15px"></img>  Upload</span>
                        <input type="file" class="upload" accept="image/*" onChange={this.onImageChange} />
                    </button>
                    </center>
                </div>
                
                <div className='container'>
                    <div class="row justify-content-center">
                        {
                            
                            this.state.image.map(({img_id,img_src,img_name},index) =>
                                <div key={index} class="col-xs-12 col-sm-6 col-md-4">
                                    <figure className="f">
                                        <img src={img_src} alt="image" width="285px" height="200px"/>
                                        <center><figcaption>{img_name}{" "+(index+1)}</figcaption></center>
                                    </figure>
                                </div>
                            )}

                    </div>
                   
                </div>
                
            </div>
        )
    }

    }
}

export default Cycle

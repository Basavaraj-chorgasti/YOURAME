import React from 'react';

import './App.css';
import Cycle from './Cycle';
import "./Style.css";
function App() {
  return (
    <div className="head" 
    style={{
      backgroundColor: '#e2e8f0',
      width: '1093px',
      height: 'auto'
    }}>
      <div className='header'>
        <span>Gallery</span>
      </div>
      <div className='content'>
      <Cycle/>
      <br></br>

      </div>
     <div className='footer'>
       <span>Fullstack Challenge - 2020</span>
     </div>
    </div>
  );
}

export default App;

﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MyBall : MonoBehaviour
{
    Vector3 target = new Vector3(3, 1.5f, 0);

    Rigidbody rigid;
    void Start()
    {
        rigid = GetComponent<Rigidbody>();
        
    }
    void FixedUpdate()
    {
     
       
            float h = Input.GetAxisRaw("Horizontal");
            float v = Input.GetAxisRaw("Vertical");
            Vector3 vec = new Vector3(h, 0, v);
            
            rigid.AddForce(vec, ForceMode.Impulse);

        

   
    }

    private void OnTriggerStay(Collider other)
    {
        if (other.name == "Cube")
            rigid.AddForce(Vector3.up * 2, ForceMode.Impulse);
    }

    public void Jump()
    {
        rigid.AddForce(Vector3.up * 20, ForceMode.Impulse);

    }

}

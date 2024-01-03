// NoticeDetail.js

import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../components/Header';
import Footer from '../components/Footer';
import Nav from './Nav';
import './NoticeDetail.css';
import axios from 'axios'; // axios 추가

const NoticeDetail = ({ match }) => {
  // match 객체 또는 match.params가 undefined일 경우를 방지하기 위해 optional chaining 사용
  const { id } = match?.params || {};
  const navigate = useNavigate(); // useHistory 삭제
  const [notice, setNotice] = useState(null);

  useEffect(() => {
      const fetchNotice = async () => {
        try {
          const response = await axios.get(`/api/notices/${id}`);
          setNotice(response.data);
        } catch (error) {
          console.error('Error fetching notice detail:', error);
          // 에러가 발생할 경우, 예를 들어 공지가 없는 경우 등에 대한 처리를 추가할 수 있습니다.
          // history.push('/NoticeList'); // 에러 발생 시 목록 페이지로 이동
        }
      };

      fetchNotice();
    }, [id, navigate]);

  if (!notice) {
    return <div className='loading'>Loading...</div>;
  }

  return (
    <>
    <Header />
      <div className="container">
      <Nav />
      <div className="content">
        <div className='notice-header'>
          <h3>공지사항</h3>
        </div>
        <div className='notice-info'>
          <span className='notice-date'>{notice.noticeDate}</span>
          <p>{notice.noticeCate} {notice.noticeTitle}</p>
        </div>
        <div className='notice-content'>
          <div className='notice-body' dangerouslySetInnerHTML={{ __html: notice.noticeContents }}></div>
        </div>
        <div className='btn_list'>
          <a href='/NoticeList'>목록보기</a>
        </div>
      </div>
      </div>
      <Footer />
    </>
  );
};

export default NoticeDetail;

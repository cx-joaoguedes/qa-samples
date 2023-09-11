import React, { useEffect, useState } from 'react';
import { useTranslation } from 'react-i18next';
import { RouteComponentProps } from 'react-router-dom';
import { Col, Row, Space } from 'antd';
import DOMPurify from 'dompurify';
import {
  Breadcrumb,
  Container,
  FullContainer,
  Label,
} from '../../../components';
import userService from './userService';
import configs from '../../../services/configs';

interface MatchParams {
  uid: string;
}

interface IDetailFaq extends RouteComponentProps<MatchParams> {
  uid?: string;
}

const DetailFaq: React.FC<IDetailFaq> = ({ match }) => {
  const { t } = useTranslation();
  const [detail, setDetail] = useState<any>([]);

  useEffect(() => {
    if (match.params.uid) {
      userService.getFAQ(match.params.uid).then(res => {
        if (res.success) {
          setDetail(res.data);
        }
      });
    }
  }, []);

  return (
    <FullContainer direction="vertical">
      <Container direction="vertical">
        {detail && (
          <>
            <Row justify="space-between" align="middle">
              <Col>
                <Breadcrumb
                  itens={[
                    { title: t('menu_faq'), href: '#/helpcenter' },
                    { title: t('common_detail') },
                  ]}
                  title={detail.str_title}
                />
              </Col>
              <Col>
                <Space>
                  <Label>{`${t('common_category')}:`}</Label>
                  <Label bold>{detail.str_category}</Label>
                </Space>
              </Col>
            </Row>
            {detail?.str_attachment && (
              <Row>
                <Col>
                  <Space>
                    <Label bold>{`${t('common_attachment')}:`}</Label>
                    <a
                      href={`${configs.file_api_url}/${
                        configs.apiVersion
                      }/${detail.str_attachment?.replace('files/', '')}`}
                      download={detail.str_attachment_name}
                    >
                      {detail?.str_attachment_name}
                    </a>
                  </Space>
                </Col>
              </Row>
            )}
            <div
              dangerouslySetInnerHTML={{ __html: detail.str_body }}
            />
          </>
        )}
      </Container>
    </FullContainer>
  );
};

export default DetailFaq;
